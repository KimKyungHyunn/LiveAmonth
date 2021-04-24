package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.*;

@Controller
public class CityInfoController {
    @Autowired
    private CityInfoService cityInfoService;

    @GetMapping("/cityInfo")
    public String cityInfo(Model model) throws Exception {
        /*
         컨트롤러     ->        서비스         ->        매퍼
               service.@@()              mapper.@@@()
         */
        List<CityInfoVO> cityInfoList = cityInfoService.getAllCityInfoList();
        System.out.println("리스트 개수: " + cityInfoList.size());

        model.addAttribute("cityInfoList", cityInfoList);
        return CITY_INFO.getPath();
    }

    @GetMapping("/seoulInfo")
    public String seoulInfo(Model model) throws Exception {
        List<CityInfoVO> seoulInfoList = cityInfoService.getCityInfoList("서울");
        CityInfoVO seoulInfo = new CityInfoVO();
        List<CityInfoVO> seoulFoodList = new ArrayList<>();
        List<CityInfoVO> seoulViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : seoulInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) seoulInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) seoulFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) seoulViewList.add(cityInfoVO);
        }

        System.out.println("리스트 개수: " + seoulInfo.getCityName());
        System.out.println("리스트 개수: " + seoulInfoList.size());
        System.out.println("리스트 개수: " + seoulViewList.size());

        model.addAttribute("seoulInfo", seoulInfo);
        model.addAttribute("seoulFoodList", seoulFoodList);
        model.addAttribute("seoulViewList", seoulViewList);
        return SEOUL_INFO.getPath();
    }

    @GetMapping("/jejuInfo")
    public String jejuInfo(Model model) throws Exception {
        List<CityInfoVO> jejuInfoList = cityInfoService.getCityInfoList("제주");
        CityInfoVO jejuInfo = new CityInfoVO();
        List<CityInfoVO> jejuFoodList = new ArrayList<>();
        List<CityInfoVO> jejuViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : jejuInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) jejuInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) jejuFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) jejuViewList.add(cityInfoVO);
        }



        model.addAttribute("jejuInfo", jejuInfo);
        model.addAttribute("jejuFoodList", jejuFoodList);
        model.addAttribute("jejuViewList", jejuViewList);
        return JEJU_INFO.getPath();
    }

    @GetMapping("/yeosuInfo")
    public String yeosuInfo(Model model) throws Exception {
        List<CityInfoVO> yeosuInfoList = cityInfoService.getCityInfoList("여수");
        CityInfoVO yeosuInfo = new CityInfoVO();
        List<CityInfoVO> yeosuFoodList = new ArrayList<>();
        List<CityInfoVO> yeosuViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : yeosuInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) yeosuInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) yeosuFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) yeosuViewList.add(cityInfoVO);
        }



        model.addAttribute("yeosuInfo", yeosuInfo);
        model.addAttribute("yeosuFoodList", yeosuFoodList);
        model.addAttribute("yeosuViewList", yeosuViewList);
        return YEOSU_INFO.getPath();
    }
    @GetMapping("/busanInfo")
    public String busanInfo(Model model) throws Exception {
        List<CityInfoVO> busanInfoList = cityInfoService.getCityInfoList("부산");
        CityInfoVO busanInfo = new CityInfoVO();
        List<CityInfoVO> busanFoodList = new ArrayList<>();
        List<CityInfoVO> busanViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : busanInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) busanInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) busanFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) busanViewList.add(cityInfoVO);
        }



        model.addAttribute("busanInfo", busanInfo);
        model.addAttribute("busanFoodList", busanFoodList);
        model.addAttribute("busanViewList", busanViewList);
        return BUSAN_INFO.getPath();
    }

    @GetMapping("/gyeongjuInfo")
    public String gyeongjuInfo(Model model) throws Exception {
        List<CityInfoVO> gyeongjuInfoList = cityInfoService.getCityInfoList("경주");
        CityInfoVO gyeongjuInfo = new CityInfoVO();
        List<CityInfoVO> gyeongjuFoodList = new ArrayList<>();
        List<CityInfoVO> gyeongjuViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : gyeongjuInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) gyeongjuInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) gyeongjuFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) gyeongjuViewList.add(cityInfoVO);
        }



        model.addAttribute("gyeongjuInfo", gyeongjuInfo);
        model.addAttribute("gyeongjuFoodList", gyeongjuFoodList);
        model.addAttribute("gyeongjuViewList", gyeongjuViewList);
        return GYEONGJU_INFO.getPath();
    }

    @GetMapping("/gangneungInfo")
    public String gangneungInfo(Model model) throws Exception {
        List<CityInfoVO> gangneungInfoList = cityInfoService.getCityInfoList("강릉");
        CityInfoVO gangneungInfo = new CityInfoVO();
        List<CityInfoVO> gangneungFoodList = new ArrayList<>();
        List<CityInfoVO> gangneungViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : gangneungInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) gangneungInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) gangneungFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) gangneungViewList.add(cityInfoVO);
        }



        model.addAttribute("gangneungInfo", gangneungInfo);
        model.addAttribute("gangneungFoodList", gangneungFoodList);
        model.addAttribute("gangneungViewList", gangneungViewList);
        return GANGNEUNG_INFO.getPath();
    }
}
