package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.service.IGoodsManagerService;
import com.mall.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("manager")
public class GoodsManagerController {


    private IGoodsManagerService iGoodsManagerService;


    @RequestMapping(value = "goodsE0")
    @ResponseBody
    public R getGoodsStateE0(@RequestParam int pn,@RequestParam int ps){
        ManagerGoodsForm query = new ManagerGoodsForm();
        query.setPn(pn);
        query.setPs(ps);
        System.out.println("pn:"+query.getPn());
        System.out.println("ps:"+query.getPs());
        System.out.println("跳转至goodsE0");
        //获取查询的数据

        return R.ok().put("page", iGoodsManagerService.getGoodsByStateE0(query));
    }
    @RequestMapping("goodsE1")
    @ResponseBody
    public String getGoodsStateE1(ManagerGoodsForm query){
        return "";
    }

    @RequestMapping("addGoods")
    @ResponseBody
    public String addGoodsBy0To1(@RequestParam int id){
        iGoodsManagerService.updateGoodsState(id);
        return "update success";
    }

    @RequestMapping("deleteGoods")
    @ResponseBody
    public String deleteGoods(@RequestParam int id){
        iGoodsManagerService.deleteGoodsById(id);
        return "delete success";
    }

    @RequestMapping("/")
    public ModelAndView toManager(ManagerGoodsForm query){
        //创建一个模型视图对象
        ModelAndView mav = new ModelAndView();
        mav.setViewName("managerBackstage");
        return mav;
    }
}
