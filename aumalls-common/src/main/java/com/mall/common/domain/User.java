package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class User implements Serializable{

    @TableId
    private Integer userId;
    private String userName;
    private String userPass;
    private String userAddress;
    private String userPhone;
    public Long userWhitetime;

    public Long getUserWhitetime() {
        return userWhitetime;
    }

    public void setUserWhitetime(Long userWhitetime) {
        this.userWhitetime = userWhitetime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userWhitetime=" + userWhitetime +
                '}';
    }
}
