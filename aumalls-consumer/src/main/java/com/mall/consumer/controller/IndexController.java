package com.mall.consumer.controller;

import com.mall.common.form.user.LoginForm;
import com.mall.common.utils.IPUtils;
import com.mall.common.validator.ValidatorUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Egan
 * @date 2019/7/12 16:01
 **/
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
