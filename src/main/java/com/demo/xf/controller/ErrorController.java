package com.demo.xf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Xiong Feng
 * @Date: 2020/6/24 11:38
 * @Description:
 */
@Controller
public class ErrorController {
    @GetMapping("/error/404")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/error/500")
    public String error500(){
        return "error/500";
    }
}
