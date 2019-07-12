package com.mall.common.form.user;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/10 10:15
 **/
public class LoginForm implements Serializable{

    @NotBlank(message = "账号不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
