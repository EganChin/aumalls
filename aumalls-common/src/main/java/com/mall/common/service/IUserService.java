package com.mall.common.service;

import com.mall.common.form.user.LoginForm;
import com.mall.common.vo.user.LoginVO;

/**
 * @author Egan
 * @date 2019/7/10 10:09
 **/
public interface IUserService {


    /**
     * 登录
     * @date 2019/7/10 10:20
     * @param form 登录表单
     **/
    LoginVO login(LoginForm form);

}
