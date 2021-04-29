package com.liveamonth.liveamonth.controller;

import javax.servlet.http.HttpServletRequest;

import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	private CityInfoService cityInfoService;

	@RequestMapping(value = "/")
	public String main(Model model, HttpServletRequest request)  throws Exception{
//		List<CityInfoVO> cityIntroList = cityInfoService.getCityInfoListByCategory(CATEGORY_INTRO.getCategoryUppercase());
//		List<String> cityNameList = cityInfoService.getCityInfoNameList();
//
//		model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
//		model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
		return "Main";
	}

}
