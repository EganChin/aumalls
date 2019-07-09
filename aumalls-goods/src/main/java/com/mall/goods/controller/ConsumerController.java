package com.mall.goods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.service.IProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Egan
 * @date 2019/7/8 15:23
 **/
@RestController
public class ConsumerController {

    @Resource
    @Reference(version = "1.0.0")
    private IProvider provider;

    @RequestMapping("/consumer")
    public String invoke(){
        return provider.invoke();
    }
}
