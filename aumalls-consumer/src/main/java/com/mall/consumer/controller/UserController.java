package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egan
 * @date 2019/7/10 10:44
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    private UserService userService;
<<<<<<< HEAD

=======
>>>>>>> b4db1c4b5dd85a3c97ba593f393e614f7f87d8d8

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(@RequestBody LoginForm form){
        ValidatorUtils.validate(form);
        return R.ok().put("vo", userService.UserLogin(form));
    }
}
