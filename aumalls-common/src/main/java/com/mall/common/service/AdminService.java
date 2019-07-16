package com.mall.common.service;

import com.mall.common.form.user.LoginForm;
import com.mall.common.vo.user.LoginVO;

/**
 * @author Egan
 * @date 2019/7/10 10:09
 **/
public interface AdminService {


    /**
     * 管理员登录
     * @date 2019/7/15 14:01
     * @param form
     **/
    LoginVO adminLogin(LoginForm form);

}
