package com.mall.common.service;

import com.mall.common.domain.User;
import com.mall.common.form.user.LoginForm;
import com.mall.common.vo.user.LoginVO;

import java.util.List;

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


    User findUserByTel(String phone);
    User findUserByName(String user_name);
    int addUser(User user);
    int modifyUserinfo(User user);
    void deleteUserinfo(int user_id);
    List<User> findUserByUserId(int user_id);
    List<User> getUserList();
}
