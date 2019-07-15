package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.AdminService;
import com.mall.common.utils.R;
import com.mall.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egan
 * @date 2019/7/15 14:14
 **/
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Reference
    private AdminService adminService;

    @RequestMapping("login")
    public R login(@RequestBody LoginForm form){
        ValidatorUtils.validate(form);
        return R.ok().put("vo", adminService.adminLogin(form));
    }

}
