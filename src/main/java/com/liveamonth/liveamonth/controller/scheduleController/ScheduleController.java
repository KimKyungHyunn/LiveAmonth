package com.liveamonth.liveamonth.controller.scheduleController;

import com.liveamonth.liveamonth.constants.ControllerPathConstants;
import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.CityVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.REDIRECT_SCHEDULE;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.SCHEDULE;
import static com.liveamonth.liveamonth.constants.EntityConstants.ECity.CITY_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleContent.SCHEDULE_CONTENT_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CityService cityService;

    private int scheduleContentNO;

    @RequestMapping(value = "addScheduleContent")
    public String addScheduleContent(HttpServletRequest request, ScheduleContentVO scheduleContentVO, RedirectAttributes rttr) throws Exception {
        HttpSession session = request.getSession();
        scheduleContentVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));
        int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

        String message = "";
        if (count >= 4) {
            message = MAXIMUM_SCHEDULE_CONTENT.getText();
        } else {
            scheduleService.addScheduleContent(scheduleContentVO);
            message = ADD_SCHEDULE_CONTENT.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value = "deleteScheduleContent")
    public String deleteScheduleContent(RedirectAttributes rttr) throws Exception {
        scheduleService.deleteScheduleContent(scheduleContentNO);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value = "modifyScheduleContent")
    public String modifyScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
        String scheduleContentSubject = request.getParameter(MODIFY_SCHEDULE_CONTENT_SUBJECT.getText());
        String scheduleContentDesc = request.getParameter(MODIFY_SCHEDULE_CONTENT_DESC.getText());
        int scheduleContentCost = Integer.parseInt(request.getParameter(MODIFY_SCHEDULE_CONTENT_COST.getText()));
        scheduleService.modifyScheduleContent(scheduleContentNO, scheduleContentSubject, scheduleContentDesc, scheduleContentCost);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_MODIFICATION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/schedule")
    public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        model.addAttribute(SCHEDULE_PLACE_LIST.getText(), cityService.getCityNameList());

        ArrayList<ScheduleVO> scheduleVOList;
        try {
            scheduleVOList = scheduleService.getScheduleList(userNO);
            //System.out.println(scheduleVOList.get(0).getCityVO().getCityName());
            model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
            if (scheduleVOList.isEmpty()) {
                model.addAttribute(MESSAGE.getText(), "아직 캘린더를 생성하지 않으셨습니다. 캘린더를 추가해주세요.");
            }
        } catch (Exception e) {
            model.addAttribute(MESSAGE.getText(), "캘린더 리스트 조회에 실패하셨습니다.");
            e.printStackTrace();
            return ControllerPathConstants.EMainPath.MAIN.getPath();
        }

        int scheduleNO = 0;
        if (!scheduleVOList.isEmpty()) {
            try {
                scheduleNO = Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText())));
            } catch (Exception e) {
                scheduleNO = scheduleVOList.get(0).getScheduleNO();
                session.setAttribute(SELECTED_SCHEDULE_NO.getText(), scheduleNO);
            }
        }

        CalendarDTO calendarDto = null;
        try {
            calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);
            model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList());
            model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());
        } catch (Exception e) {
            model.addAttribute(MESSAGE.getText(), "스케줄 조회에 실패하셨습니다.");
            e.printStackTrace();
        }
        return SCHEDULE.getPath();
    }


    @RequestMapping("/swapSchedule")
    public String swapSchedule(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(SELECTED_SCHEDULE_NO.getText(), request.getParameter(SELECT_SCHEDULE.getText()));
        return REDIRECT_SCHEDULE.getRedirectPath();
    }
    private HashMap<String, Object> getScehduleInfos(HttpServletRequest request, int scheduleNO,int userNO){
        HashMap<String, Object> objects = new HashMap<>();
        objects.put(SCHEDULE_VO.getText(), scheduleNO);
        objects.put(SCHEDULE_SUBJECT.getText(), request.getParameter(SCHEDULE_SUBJECT.getText()));
        if(request.getParameter(SCHEDULE_STATUS.getText()) != null)objects.put(SCHEDULE_STATUS.getText(),true);
        else objects.put(SCHEDULE_STATUS.getText(),false);
        objects.put(CITY_NO.getText(), request.getParameter(CITY_NO.getText()));
        objects.put(SCHEDULE_VIEW_COUNT.getText(), 0); //addSchedule에만 필요
        objects.put(USER_NO.getText(), userNO); // addSchedule에만 필요
        return objects;
    }

    @RequestMapping(value = "addSchedule")
    public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) {
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());

        try {
            scheduleService.addSchedule(this.getScehduleInfos(request,scheduleVO.getScheduleNO(),session_UserVO.getUserNO()));
            rttr.addFlashAttribute(MESSAGE.getText(), ADD_SCHEDULE.getText());
        } catch (Exception e) {
            rttr.addFlashAttribute(MESSAGE.getText(), FAIL_TO_ADD_SCHEDULE.getText());
            e.printStackTrace();
        }
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value = "modifySchedule")
    public String modifySchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr){
        HttpSession session = request.getSession();
        int scheduleNO = Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText())));

        try {
            scheduleService.modifySchedule(this.getScehduleInfos(request,scheduleNO,0));
            rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_MODIFICATION.getText());
        } catch (Exception e) {
            rttr.addFlashAttribute(MESSAGE.getText(),  FAIL_TO_MODIFY_SCHEDULE.getText());
            e.printStackTrace();
        }
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value = "deleteSchedule")
    public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
        HttpSession session = request.getSession();
        try {
            scheduleService.deleteSchedule(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));
            rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        } catch (Exception e) {
            rttr.addFlashAttribute(MESSAGE.getText(),  FAIL_TO_DELETE_SCHEDULE.getText());
            e.printStackTrace();
        }
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @ResponseBody
    @RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
    public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        this.scheduleContentNO = Integer.parseInt(request.getParameter(SCHEDULE_CONTENT_NO.getText()));
    }

    @RequestMapping(value = "knowScheduleDurationPay")
    public String knowScheduleDurationPay(HttpSession session, HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception {
        String schedulePayStartDay =  request.getParameter(SCHEDULE_PAY_START_DAY.getText());
        String schedulePayFinishDay =  request.getParameter(SCHEDULE_PAY_FINISH_DAY.getText());
        int scheduleNO = Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText())));

        String message = "";
        if(schedulePayStartDay == "" && schedulePayFinishDay ==""){
            message = PLEASE_ADD_DURATION.getText();
        }else{
           int scheduleDurationPay = scheduleService.getScheduleDurationPay(schedulePayStartDay,schedulePayFinishDay,scheduleNO);
            message = String.valueOf(scheduleDurationPay) + WON.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);

        return REDIRECT_SCHEDULE.getRedirectPath();
    }
}
