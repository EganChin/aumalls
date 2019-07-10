package com.mall.common.vo.user;

import com.mall.common.domain.User;

import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/10 10:12
 **/
public class LoginVO implements Serializable{

    private String token;

    private Integer userId;

    public LoginVO() {
    }

    public LoginVO(User user, String token) {
        setUserId(user.getUserId());
        setToken(token);
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
