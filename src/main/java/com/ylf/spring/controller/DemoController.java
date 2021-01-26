package com.ylf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/25 10:43
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping("/test")
    @ResponseBody
    public Object test(HttpServletRequest req, HttpServletResponse resp){
        return "test";
    }
}
