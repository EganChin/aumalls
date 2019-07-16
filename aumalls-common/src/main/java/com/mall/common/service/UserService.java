package com.mall.common.service;

import com.mall.common.form.user.LoginForm;
import com.mall.common.vo.user.LoginVO;

/**
 * @author Egan
 * @date 2019/7/10 10:09
 **/
public interface UserService {


    /**
     * 用户登录
     * @date 2019/7/10 10:20
     * @param form 登录表单
     **/
    LoginVO UserLogin(LoginForm form);

}
