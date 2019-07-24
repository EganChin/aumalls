package com.mall.consumer.controller;

import com.google.gson.Gson;
import com.mall.common.domain.User;
import com.mall.common.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("toRegister")
public class RegisterController {
    private UserService userService;

    //    @RequestMapping("/")
//    public ModelAndView toRegister(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("register");
//        return mav;
//    }

    @RequestMapping("register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @RequestMapping(value = "addUser")
    public String addUser(User user) {
        System.out.println("进入addUser=" + user.getUserName());
        userService.addUser(user);
        return "login";
    }

}
