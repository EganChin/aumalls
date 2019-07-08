package com.mall.controller;

import com.mall.entity.Users;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;

/**
 * @author LiangYongjie
 * @date 2019-01-12
 */
public class BaseController {

    public Users getUser() {
        return (Users) SecurityUtils.getSubject().getPrincipal();
    }

    public Integer getUserId() {
        return Optional.ofNullable(this.getUser()).map(Users::getUserId).orElse(null);
    }
}
