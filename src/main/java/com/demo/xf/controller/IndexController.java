package com.demo.xf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 9:57
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
