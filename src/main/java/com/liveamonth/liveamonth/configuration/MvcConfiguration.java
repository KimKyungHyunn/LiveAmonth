package com.liveamonth.liveamonth.configuration;

import com.liveamonth.liveamonth.model.mapper.cityInfoMapper.CityInfoMapper;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.liveamonth.liveamonth.intercepter.LoggerInterceptor;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/schedule");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/myPage");
        //registry.addInterceptor(new LoggerInterceptor()).excludePathPatterns("resources/**/**", "/ResultMentSignUp","/SignIn");
    }
}