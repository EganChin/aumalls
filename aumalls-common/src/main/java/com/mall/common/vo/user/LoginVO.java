package com.mall.common.vo.user;

import com.mall.common.domain.Admin;
import com.mall.common.domain.User;

import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/10 10:12
 **/
public class LoginVO implements Serializable{

    private String token;

    private Integer userId;

    private String userName;


    public LoginVO() {
    }

    public LoginVO(User user, String token) {
        setUserId(user.getUserId());
        setToken(token);
        setUserName(user.getUserName());
        setUserId(1);
    }

    public LoginVO(Admin admin, String token) {
        setUserName(admin.getAdminName());
        setUserId(admin.getAdminId());
        setToken(token);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
