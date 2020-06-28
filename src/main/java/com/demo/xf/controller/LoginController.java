package com.demo.xf.controller;

import com.demo.xf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 10:40
 * @Description:
 */
@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/login")
    public String Login(HttpSession session, Model model, User user){
        if (!"alex".equals(user.getUsername())){
            model.addAttribute("errorMsgU", "用户名错误");
            return "login";
        }
        if (!"123".equals(user.getPassword())){
            model.addAttribute("errorMsgP", "密码错误");
            return "login";
        }
        session.setAttribute("token", "123");
        session.setAttribute("user", user.getUsername());
        return "redirect:/user/getUserInfo";
    }

    @RequestMapping("/exit")
    public String Logout(HttpSession session) throws Exception{
        session.invalidate();
        return "redirect:/toLogin";
    }
}
