package com.demo.xf.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/26 13:34
 * @Description:
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        String uri = request.getRequestURI();
        System.out.println("拦截请求:"+uri);
        if (user == null){
            response.sendRedirect("/toLogin");
            return false;
        }
        return true;
    }
}
