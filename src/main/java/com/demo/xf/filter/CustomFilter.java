package com.demo.xf.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 9:48
 * @Description: 自定义过滤器，用于学习测试
 */
//@WebFilter(filterName = "filter", urlPatterns = "/*",
//        initParams = {
//                @WebInitParam(name="URL_LIST", value = "classpath:config/filterConfig.properties")
//        })
@Order(1)
public class CustomFilter implements Filter {

    private List list;

    @Override
    public void init(FilterConfig filterConfig){
       String url = filterConfig.getInitParameter("URL_LIST");
       this.list = Arrays.asList(url.split(","));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器，我拦截了方法了");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        System.out.println("我拦截的路径是:"+request.getServletPath()+"   拦截的URI是:"+uri);
        if (list.contains(uri)){
            if (session != null && session.getAttribute("token") != null){
                if (session.getAttribute("token").equals("123")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    response.sendRedirect("/toLogin");
                }
            }else {
                response.sendRedirect("/index");
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("I AM Done");
    }
}
