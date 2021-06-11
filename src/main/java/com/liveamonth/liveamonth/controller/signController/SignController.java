package com.liveamonth.liveamonth.controller.signController;

import com.liveamonth.liveamonth.constants.EntityConstants.EEmail;
import com.liveamonth.liveamonth.controller.SuperController;
import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.signService.SignService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESignPath.*;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ETemplatePath.MAIN;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESignUp.EMAIL;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ENaverApiUrl.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ENaverLoginAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.MESSAGE;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.*;

@Controller
public class SignController extends SuperController {

    @Autowired
    private SignService signService;

    //naver login api에 접속
    @RequestMapping("/signIn")
    public String SignInPage(Model model, HttpSession session) throws Exception {
        StringBuffer apiURL = new StringBuffer();
        apiURL.append(NAVER_SIGN_IN_API_URL.getText());
        apiURL.append(NAVER_ADD_CLIENT_ID.getText() + NAVER_CLIENT_ID.getText());
        apiURL.append(NAVER_ADD_REDIRECT_URI.getText() + URLEncoder.encode(NAVER_REDIRECT_URI.getText(), ENCODE_UTF_8.getText()));
        String state = new BigInteger(130, new SecureRandom()).toString();
        apiURL.append(NAVER_ADD_STATE.getText() + state);

        session.setAttribute(STATE.getText(), state);
        model.addAttribute(API_URL.getText(), apiURL);
        model.addAttribute(FIRST_IN.getText(), true);
        return SIGN_IN.getPath();
    }
    @RequestMapping("/logout")
    private String logout(HttpSession session, Model model,CalendarDTO calendarDTO) throws Exception {
        session.invalidate();
        super.setMainPageAttributes(model, calendarDTO);
        return MAIN.getPath();
    }

    @RequestMapping("/checkSign")
    public String checkSign(Model model, HttpServletRequest request, HttpSession session,CalendarDTO calendarDTO) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);

        if (userVO == null) {
            model.addAttribute(FIRST_IN.getText(), false);
            return SIGN_IN.getPath();
        } else {
            super.setMainPageAttributes(model,calendarDTO);
            session.setAttribute(USER_VO.getText(), userVO);
            super.setMainSideBarAttributes(model, userVO);
            return MAIN.getPath();
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model){
        model.addAttribute(EMAIL.getText(), EEmail.values());
        return SIGN_UP.getPath();
    }

    @RequestMapping("/naverSignUp")
    public String naverSignUp(Model model){
        model.addAttribute(EMAIL.getText(), EEmail.values());
        return NAVER_SIGN_UP.getPath();
    }

    // 회원가입 진행 Check
    @ResponseBody
    @PostMapping(value = "/checkID")
    public int postCheckID(HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String idCheck = signService.checkID(userID);

        int idExist = 0;
        if (idCheck != null) idExist = 1;
        return idExist;
    }

    @ResponseBody
    @PostMapping(value = "/checkNickName")
    public int postNickNameCheck(HttpServletRequest request) throws Exception {
        String userNickname = request.getParameter(USER_NICKNAME.getText());
        String nickNameCheck = signService.checkNickName(userNickname);

        int nickNameExist = 0;
        if (nickNameCheck != null) nickNameExist = 1;
        return nickNameExist;
    }

    @ResponseBody
    @PostMapping(value = "/checkEmail")
    public int postCheckEmailCheck(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String emailCheck = signService.checkEmail(userEmail);

        int emailExist = 0;
        if (emailCheck != null) emailExist = 1;
        System.out.println(emailCheck);
        return emailExist;
    }

    @RequestMapping("/resultMentSignUp")
    private String resultMentSignUp(@ModelAttribute UserVO userVO, HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String email = request.getParameter(EMAIL.getText());

        userVO.setUserEmail(userEmail + AT.getText() + email);

        signService.insertUser(userVO);
        return RESULT_MENT_SIGN_UP.getPath();
    }

    // 아이디 비밀번호 찾기
    @RequestMapping("/findID")
    private String findID(Model model){
        model.addAttribute(FIRST_IN.getText(), true);
        return FIND_ID.getPath();
    }
    @RequestMapping("/findPW")
    private String findPW(Model model){
        model.addAttribute(FIRST_IN.getText(), true);
        return FIND_PW.getPath();
    }
    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String resultMentFindID(@RequestParam("userName") String userName,
                                   @RequestParam("userEmail") String userEmail, Model model) throws Exception {
        String foundUserID = signService.findID(userName, userEmail);
        if (foundUserID != null) {
            model.addAttribute(FIRST_IN.getText(), true);
            model.addAttribute(USER_ID.getText(), foundUserID);
            return RESULT_MENT_FIND_ID.getPath();
        }else {
            model.addAttribute(FIRST_IN.getText(), false);
            return FIND_ID.getPath();
        }
    }

    @RequestMapping(value = "/ResultMentFindPW", method = RequestMethod.POST)
    public String ResultMentFindPW(@RequestParam("userID") String userID,
                                   @RequestParam("userName") String userName,
                                   @RequestParam("userEmail") String userEmail,
                                   Model model) throws Exception {
        if (!signService.findPW(userID, userName,userEmail)){
            model.addAttribute(FIRST_IN.getText(), false);
            return FIND_PW.getPath();
        }else{
            model.addAttribute(FIRST_IN.getText(), true);
            return RESULT_MENT_FIND_PW.getPath();
        }
    }

    @RequestMapping("/naverLogin")
    private String naverLogin(HttpSession session, HttpServletRequest request) throws Exception {
        String access_token = "";
        StringBuffer apiURL = new StringBuffer();
        apiURL.append(NAVER_LOGIN_API_URL.getText());
        apiURL.append(NAVER_ADD_CLIENT_ID.getText() + NAVER_CLIENT_ID.getText());
        apiURL.append(NAVER_ADD_CLIENT_SECRET.getText() + NAVER_CLIENT_SECRET.getText());
        apiURL.append(NAVER_ADD_REDIRECT_URI.getText() + URLEncoder.encode(NAVER_REDIRECT_URI.getText(), ENCODE_UTF_8.getText()));
        apiURL.append(NAVER_ADD_CODE.getText() + request.getParameter(CODE.getText()));
        apiURL.append(NAVER_ADD_STATE.getText() + request.getParameter(STATE.getText()));

        try {
            URL url = new URL(apiURL.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer res = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                res.append(inputLine);
            }
            br.close();
            if (responseCode == 200) {
                JSONParser parsing = new JSONParser();
                Object obj = parsing.parse(res.toString());
                JSONObject jsonObj = (JSONObject) obj;

                access_token = (String) jsonObj.get(ACCESS_TOKEN.getText());
                session.setAttribute(ACCESS_TOKEN.getText(), access_token);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        UserVO naverUser = signService.setTokenInfo(access_token);
        String naverID = signService.checkNaverID(naverUser.getUserID());

        //회원, 비회원 체크
        if (naverID != null && !"null".equals(naverID)) {
            //session 변경해서 로그인 상태로 만들기
            UserVO userVO = signService.getNaverUser(naverID);
            session.setAttribute(USER_VO.getText(),userVO);
            return REDIRECT_MAIN.getRedirectPath();
        } else {
            session.setAttribute(NAVER_USER.getText(), naverUser);
            return NEW_NAVER_MEMBER.getPath();
        }
    }
    @RequestMapping("/resultMentNaverSignUp")
    private String resultMentNaverSignUp(@ModelAttribute UserVO userVO, HttpServletRequest request, HttpSession session, Model model) throws Exception {
        //email을 갖고 있는 경우와 아닌 경우
        if(!userVO.getUserEmail().contains("@")){
            String userEmail = request.getParameter(USER_EMAIL.getText());
            String email = request.getParameter(EMAIL.getText());
            userVO.setUserEmail(userEmail + AT.getText() + email);
        }
        signService.updateNaverUser(userVO);
        model.addAttribute(MESSAGE.getText(), SUCCESS_SIGN_UP_MESSAGE.getText());

        session.setAttribute(USER_VO.getText(),userVO);
        return RESULT_NEW_NAVER_MEMBER.getPath();
    }
    @RequestMapping("/newNaverMember")
    private String newNaverMember(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        UserVO newNaverUser = (UserVO)session.getAttribute(NAVER_USER.getText());
        boolean flag = true;

        if(newNaverUser.getUserSex() == null || newNaverUser.getUserEmail() == null || newNaverUser.getUserName() == null||
                newNaverUser.getUserNickname() == null || newNaverUser.getUserAge() == 0){
            flag = false;
        }

        if(session.getAttribute(USER_VO.getText()) == null && signService.setNewNaverMember(newNaverUser)==1){
            //필수항목 다 동의 한 경우
            if(flag){
                //session.setAttribute(USER_VO.getText(),newNaverUser);
                model.addAttribute(MESSAGE.getText(), SUCCESS_SIGN_UP_MESSAGE.getText());
            }else{ //필수 항목 하나라도 동의 안한 경우
                return REDIRECT_NAVER_SIGN_UP.getRedirectPath();
            }
        }else{
            model.addAttribute(MESSAGE.getText(), FAIL_SIGN_UP_MESSAGE.getText());
        }

        return RESULT_NEW_NAVER_MEMBER.getPath();
    }

}