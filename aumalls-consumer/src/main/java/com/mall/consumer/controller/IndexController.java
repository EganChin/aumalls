package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private IGoodsService goodsService;

//    @Autowired
//    private HttpServletRequest request;

    @RequestMapping("/")
    public String index(Map<String, Object> model){


        model.put("typeList", goodsService.getSeniorTypes());
        model.put("goodsPage", goodsService.getPage(new QueryGoodsForm()));

        return "index";
    }

}
