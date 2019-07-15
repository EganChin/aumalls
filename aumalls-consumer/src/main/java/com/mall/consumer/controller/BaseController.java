package com.mall.consumer.controller;

import com.mall.common.domain.Admin;
import com.mall.common.domain.Operator;
import com.mall.common.domain.User;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;

/**
 * @author LiangYongjie
 * @date 2019-01-12
 */
public class BaseController {

    public Admin getAdmin() {
        return getOperator().toAdmin();
    }

    public User getUser() {
        return getOperator().toUser();
    }

    public Operator getOperator() {
        return (Operator) SecurityUtils.getSubject().getPrincipal();
    }

}
