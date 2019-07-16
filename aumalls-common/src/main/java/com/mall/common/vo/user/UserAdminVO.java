package com.mall.common.vo.user;

import java.io.Serializable;

/**
 * Created by zzy on 2019/7/15.
 */
public class UserAdminVO implements Serializable{

    private Integer userId;
    private String userName;
    private String userPass;
    private String userAddress;
    private String userPhone;

    private String userWhitetime;

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

    public String getUserWhitetime() {
        return userWhitetime;
    }

    public void setUserWhitetime(String userWhitetime) {
        this.userWhitetime = userWhitetime;
    }
}
