package com.mall.consumer.controller;

import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.domain.Goods;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.service.IGoodsManagerService;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.ApplyGoodsVO;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("manager")
public class GoodsManagerController {
    @Reference
    private IGoodsManagerService iGoodsManagerService;


    @RequestMapping(value = "goodsE0")
    @ResponseBody
    public String getGoodsStateE0(@RequestBody ManagerGoodsForm query){
        System.out.println("pn:"+query.getPn());
        System.out.println("ps:"+query.getPs());
        System.out.println("跳转至goodsE0");
        //获取查询的数据
        JSONArray json = new JSONArray();
        List<ApplyGoodsVO> applyGoods = (List<ApplyGoodsVO>) iGoodsManagerService.getGoodsByStateE0(query).getList();
        System.out.println("getPs()："+iGoodsManagerService.getGoodsByStateE0(query).getPs());
        System.out.println("getTotal()："+iGoodsManagerService.getGoodsByStateE0(query).getTotal());
        System.out.println("getList().get(2)："+iGoodsManagerService.getGoodsByStateE0(query).getList().get(0));
        for(ApplyGoodsVO apply : applyGoods){
            JSONObject jo = new JSONObject();
            jo.put("goodsName",apply.getGoodsName());
            jo.put("goodsPrice",apply.getGoodsPrice());
            jo.put("goodsNumber",apply.getGoodsNum());
            jo.put("goodsId",apply.getGoodsId());
            jo.put("goods",apply.getTypeName());
            json.add(jo);
        }
        return json.toString();
    }
    @RequestMapping("goodsE1")
    @ResponseBody
    public String getGoodsStateE1(ManagerGoodsForm query){
        System.out.println("跳转至此！");
        //获取查询的数据
        JSONArray json = new JSONArray();
        List<Goods> goods = iGoodsManagerService.getGoodsByStateE1(query);
        for(Goods good : goods){
            JSONObject jo = new JSONObject();
            jo.put("goodsName",good.getGoodsName());
            jo.put("goodsId",good.getGoodsId());
            jo.put("goodsNum",good.getGoodsNum());
            json.add(jo);
        }
        System.out.println("测试:"+goods.get(0).getGoodsName());
        //放入jsp路径
        return json.toString();
    }
    @RequestMapping("/")
    public ModelAndView toManager(ManagerGoodsForm query){
        //创建一个模型视图对象
        ModelAndView mav = new ModelAndView();
        //放入已上架商品
//        mav.addObject("goodsE1", iGoodsManagerService.getGoodsByStateE1(query));
        //放入已注册用户数量
//        mav.addObject("userNumber", iGoodsManagerService.getUserCount());
//        //放入待上架商品
//        mav.addObject("goodsE0", iGoodsManagerService.getGoodsByStateE0(query));
        //设置返回路径
        mav.setViewName("managerBackstage");
        return mav;
    }
}
