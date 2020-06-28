package com.demo.xf.config;

import com.demo.xf.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/26 13:40
 * @Description:
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    private List<String> list = Arrays.asList("/", "/index", "/toLogin","/login", "/error/**", "/css/**", "/images/**", "/js/**");

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
