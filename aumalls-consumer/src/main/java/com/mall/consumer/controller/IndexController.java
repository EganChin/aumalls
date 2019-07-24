package com.mall.consumer.controller;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.R;
import com.mall.consumer.service.GoodsService;
import com.mall.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Egan
 * @date 2019/7/12 16:01
 **/
@Controller
public class IndexController {

    //    @Reference
    @Autowired
    private GoodsService goodsService;

    //    @Reference
    private UserService userService;

    @RequestMapping("/")
    public String index(Map<String, Object> model, QueryGoodsForm form) {

        model.put("typeList", goodsService.getSeniorTypes());
        model.put("goodsPage", goodsService.getPage(form));
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
