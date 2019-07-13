package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.domain.Goods;
import com.mall.common.service.IGoodsManagerService;
import com.mall.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("manager")
public class GoodsManagerController {
    @Reference
    private IGoodsManagerService iGoodsManagerService;
    @RequestMapping("goodsE0")
    public R getGoodsStateE0(){
        List<Goods> goods = iGoodsManagerService.getGoodsByStateE0();

        return R.ok().put("data",goods);
    }
    @RequestMapping("goodsE1")
    public ModelAndView getGoodsStateE1(){
        //创建一个模型视图对象
        System.out.println("跳转至此！");
        ModelAndView mav = new ModelAndView();
        //获取查询的数据
        List<Goods> goods = iGoodsManagerService.getGoodsByStateE1();
        System.out.println("测试:"+goods.get(0).getGoodsName());
        mav.addObject("goodsE1",goods);
        //放入jsp路径
        mav.setViewName("managerBackstage");
        return mav;
    }
}
