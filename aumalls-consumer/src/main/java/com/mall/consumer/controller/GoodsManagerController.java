package com.mall.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class GoodsManagerController {
    @RequestMapping("/goods")
    @ResponseBody
    public String getGoodsStateE0(){

        return "";
    }
}
