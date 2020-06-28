package com.demo.xf.controller;

import com.demo.xf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 10:16
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session, Model model){
        List<User> list = new ArrayList<>();
        list.add(new User("Alex", 18, "男"));
        list.add(new User("Tom", 25, "男"));
        list.add(new User("Mary", 23, "女"));
        model.addAttribute("userInfo", list);
        session.setAttribute("userList", list);
        return "userList";
    }

    @PostMapping("queryUser")
    public String queryUser(Model model){
        List<User> result = new ArrayList<>();
        User user1 = new User("Alex", 18, "男");
        result.add(user1);
        model.addAttribute("userInfo", result);
        return "userList";
    }

}
