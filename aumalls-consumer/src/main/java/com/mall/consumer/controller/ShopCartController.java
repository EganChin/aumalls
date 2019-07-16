package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.service.IUserShopCartService;
import com.mall.common.utils.R;
import com.mall.common.vo.shoppingcart.ShoppingCartItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/7/12.
 */
@Controller
@RequestMapping("shopcart")
public class ShopCartController extends BaseController{

   @Reference
    private IUserShopCartService shopCartService;

  @RequestMapping("getUserShopCartIterm")
    public ModelAndView getUserShopCartIterm(){

        ModelAndView modelAndView = new ModelAndView();

        List<ShoppingCartItem> userShoppingIterms = shopCartService.getUserShoppingIterms(getUserId());
        modelAndView.addObject("data", userShoppingIterms);
        modelAndView.setViewName("shopiterm");

        return modelAndView;

    }

    @ResponseBody
    @RequestMapping("addTouserCart")
    public R addToUserCart(
             @RequestParam("goodsnum") int goodsnum, @RequestParam("goodsid") int goodsid){

        int i = shopCartService.addUserShopItermCart(getUserId(), goodsnum, goodsid);

        if(i < 0){
            return R.error("商品获取失败！");
        }else{
            return R.ok().put("data", i);
        }

    }

    @ResponseBody
    @RequestMapping("updataCartNum")
    public R updataCartNum(@RequestParam("itermid") int itermid, @RequestParam("goodsnum") int goodsnum){

        int i = shopCartService.updateShoppingItermNum(itermid, goodsnum);

        if(i == -1){
            return R.error("购物ItermId不存在");
        }else if(i == -2){
            return  R.error("商品ID不存在");
        }else{
            return R.ok().put("data", i);
        }


    }

    @RequestMapping("getGoodsById")
    public R getGoodsById(@RequestParam("goodsid") int goodsid){
        return R.ok().put("data", shopCartService.getGoodsInShopcart(goodsid));
    }

    @RequestMapping("flushCart")
    public void flushCart(){
        shopCartService.updateFlushCart(getUserId());
    }

    @ResponseBody
    @RequestMapping("flushCartIterm")
    public R flushCartIterm(@RequestParam("itermid") int itermid){
        return R.ok().put("data", shopCartService.updateFlushOneShopiterm(itermid));
    }

    @ResponseBody
    @RequestMapping("getUserItermNum")
    public R getUseritermNum(){

        return R.ok().put("num", shopCartService.getUserShopItermNum(getUserId()));
    }

}
