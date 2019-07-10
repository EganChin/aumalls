package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.IUserService;
import com.mall.common.utils.R;
import com.mall.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egan
 * @date 2019/7/10 10:44
 **/
@RestController
@RequestMapping("user")
public class UserController {

//    @Reference
    private IUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(@RequestBody LoginForm form){
        ValidatorUtils.validate(form);
        return R.ok().put("vo", userService.login(form));
    }
}
