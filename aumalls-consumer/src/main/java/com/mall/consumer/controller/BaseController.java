package com.mall.consumer.controller;

import com.mall.common.domain.Admin;
import com.mall.common.domain.Operator;
import com.mall.common.domain.User;

import java.util.Optional;

/**
 * @author LiangYongjie
 * @date 2019-01-12
 */
public class BaseController {

    public Integer getUserId(){return getUser().getUserId();}

    public Admin getAdmin() {
        return getOperator().toAdmin();
    }

    public User getUser() {
        return getOperator().toUser();
    }

    public Operator getOperator() {
        return null;
    }

}
