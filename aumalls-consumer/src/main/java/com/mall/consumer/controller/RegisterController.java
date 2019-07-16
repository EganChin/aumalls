package com.mall.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("register")
public class RegisterController {
    @RequestMapping("/")
    public ModelAndView toRegister(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
}
