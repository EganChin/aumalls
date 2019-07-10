package com.mall.common.form.user;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/10 10:15
 **/
public class LoginForm implements Serializable{

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String pass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
