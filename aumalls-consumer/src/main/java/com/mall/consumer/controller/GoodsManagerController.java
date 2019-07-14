package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.domain.Goods;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.service.IGoodsManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("manager")
public class GoodsManagerController {
//    @Reference
    private IGoodsManagerService iGoodsManagerService;
    @RequestMapping("goodsE0")
    public void getGoodsStateE0(ManagerGoodsForm query){

    }
    @RequestMapping("goodsE1")
    public ModelAndView getGoodsStateE1(ManagerGoodsForm query){
        //创建一个模型视图对象
        System.out.println("跳转至此！");
        ModelAndView mav = new ModelAndView();
        //获取查询的数据
        List<Goods> goods = iGoodsManagerService.getGoodsByStateE1(query);
        System.out.println("测试:"+goods.get(0).getGoodsName());
        mav.addObject("goodsE1",goods);
        //放入jsp路径
        mav.setViewName("managerBackstage");
        return mav;
    }
    @RequestMapping("/")
    public ModelAndView toManager(ManagerGoodsForm query){
        //创建一个模型视图对象
        ModelAndView mav = new ModelAndView();
        //放入已上架商品
        mav.addObject("goodsE1", iGoodsManagerService.getGoodsByStateE1(query));
        //放入已注册用户数量
        mav.addObject("userNumber", iGoodsManagerService.getUserCount());
        //放入待上架商品
        mav.addObject("goodsE0", iGoodsManagerService.getGoodsByStateE0(query));
        //设置返回路径
        mav.setViewName("managerBackstage");
        return mav;
    }
}
