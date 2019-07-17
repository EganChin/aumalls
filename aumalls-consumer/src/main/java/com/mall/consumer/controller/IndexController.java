package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.domain.User;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.service.GoodsService;
import com.mall.common.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Egan
 * @date 2019/7/12 16:01
 **/
@Controller
public class IndexController {

    @Reference
    private GoodsService goodsService;

    @Reference
    private UserService userService;

    @RequestMapping("/")
    public String index(Map<String, Object> model, QueryGoodsForm form){


        model.put("typeList", goodsService.getSeniorTypes());
        model.put("goodsPage", goodsService.getPage(form));

        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

}
