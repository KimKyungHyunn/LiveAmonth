package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import com.liveamonth.liveamonth.model.service.signService.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMyPagePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.CHECK_USER;

@Controller
public class MyPageController {
    @Autowired
    private MyPageService myPageService;
    @Autowired
    private SignService signService;

    @GetMapping("/myPage")
    public String myPage(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Object session_UserID = session.getAttribute(USER_ID.getText());
        String userID = (String)session_UserID;

        session.setAttribute(USER_VO.getText(), myPageService.getUserInfo(userID));
        return MY_PAGE.getPath();
    }

    @GetMapping("/reCheckUserPW")
    public String reCheckUserPW(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
        model.addAttribute(CHECK_USER.getText(), true);

        return RE_CHECK_USER_PW.getPath();
    }

    @GetMapping("/goToModifyUserInfo")
    public String goToModifyUserInfo(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));

        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        String userName = signService.checkSign(userID, userPassword);

        if (userName == null) {
            model.addAttribute(CHECK_USER.getText(), false);
            return RE_CHECK_USER_PW.getPath();
        } else {
            model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
            return MODIFY_USER_INFO.getPath();
        }
    }

    @RequestMapping("/resultMentModifyUserInfo")
    public String resultMentModifyUserInfo(@ModelAttribute UserVO userVO) throws Exception {
        UserVO previousUser = myPageService.getUserInfo(userVO.getUserID());

        myPageService.modifyUserInfo(this.checkUserData(userVO, previousUser));
        return RESULT_MENT_MODIFY_USER_INFO.getPath();
    }

    private UserVO checkUserData(UserVO changeData, UserVO previousData){
        UserVO checkedUserData = changeData;
        if(checkedUserData.getUserPassword().isEmpty()){
            checkedUserData.setUserPassword(previousData.getUserPassword());
        }
        if(checkedUserData.getUserNickname().isEmpty()){
            checkedUserData.setUserNickname(previousData.getUserNickname());
        }
        if(checkedUserData.getUserEmail().isEmpty()){
            checkedUserData.setUserEmail(previousData.getUserEmail());
        }
        return checkedUserData;
    }
}
