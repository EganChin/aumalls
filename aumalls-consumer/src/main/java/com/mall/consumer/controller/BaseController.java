package com.mall.consumer.controller;

import com.mall.common.domain.User;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;

/**
 * @author LiangYongjie
 * @date 2019-01-12
 */
public class BaseController {

    public User getUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public Integer getUserId() {
        return Optional.ofNullable(this.getUser()).map(User::getUserId).orElse(null);
    }
}
