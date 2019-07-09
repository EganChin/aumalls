package com.mall.user.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.mall.common.service.IProvider;

/**
 * @author Egan
 * @date 2019/7/8 16:02
 **/
@Service(version = "1.0.0")
public class Provider implements IProvider{
    @Override
    public String invoke() {
        return "I'm Provider!";
    }
}
