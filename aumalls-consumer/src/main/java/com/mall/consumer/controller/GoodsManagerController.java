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

import java.util.Map;

@Controller
@RequestMapping("manager")
public class GoodsManagerController {

    @Reference
    private IGoodsManagerService iGoodsManagerService;

    /**
     * 进入管理员界面
     * @param query
     * @return
     */
    @RequestMapping("/")
    public ModelAndView toManager(ManagerGoodsForm query){
        //创建一个模型视图对象
        ModelAndView mav = new ModelAndView();
        mav.addObject("userNumber",iGoodsManagerService.getUserCount());
        mav.setViewName("managerBackstage");
        return mav;
    }

    @RequestMapping(value = "goodsE0")
    @ResponseBody
    public R getGoodsStateE0(@RequestParam int pn,@RequestParam int ps){
        ManagerGoodsForm query = new ManagerGoodsForm();
        query.setPn(pn);
        query.setPs(ps);
        //获取查询的数据

        return R.ok().put("page", iGoodsManagerService.getGoodsByStateE0(query));
    }

    @RequestMapping("goodsE1")
    @ResponseBody
    public R getGoodsStateE1(@RequestParam int pn, @RequestParam int ps){
        ManagerGoodsForm query = new ManagerGoodsForm();
        query.setPn(pn);
        query.setPs(ps);
        return R.ok().put("page",iGoodsManagerService.getGoodsByStateE1(query));
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

    /**
     * 管理员下架商品
     * ls=lower shelf（下架）
     * @return
     */
    @RequestMapping("ls")
    @ResponseBody
    public String lsGoods(@RequestParam int id){
        iGoodsManagerService.updateGoodsStateTo0(id);
        return "下架成功";
    }

    @RequestMapping("queryGoods")
    @ResponseBody
    public R getGoodsInfoById(@RequestParam int id){
        return R.ok().put("goods",iGoodsManagerService.getGoodsInfoById(id));
    }
}
