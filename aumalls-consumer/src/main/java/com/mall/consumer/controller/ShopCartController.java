package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.service.IUserShopCartService;
import com.mall.common.utils.R;
import com.mall.common.vo.shoppingcart.ShoppingCartItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/7/12.
 */
@RestController
@RequestMapping("shopcart")
public class ShopCartController {

//    @Reference
    private IUserShopCartService shopCartService;

    @RequestMapping("getUserShopCartIterm")
    public R getUserShopCartIterm(@RequestParam("userid") int userid){

        List<ShoppingCartItem> userShoppingIterms = shopCartService.getUserShoppingIterms(userid);

        return R.ok().put("data", userShoppingIterms);

    }

    @RequestMapping("addTouserCart")
    public R addToUserCart(@RequestParam("userid") int userid
            , @RequestParam("goodsnum") int goodsnum, @RequestParam("goodsid") int goodsid){

        int i = shopCartService.addUserShopItermCart(userid, goodsnum, goodsid);

        if(i < 0){
            return R.error("商品获取失败！");
        }else{
            return R.ok().put("data", i);
        }

    }

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
    public R flushCart(@RequestParam("userid") int userid){
        return R.ok().put("data", shopCartService.updateFlushCart(userid));
    }

    @RequestMapping("flushCartIterm")
    public R flushCartIterm(@RequestParam("itermid") int itermid){
        return R.ok().put("data", shopCartService.updateFlushOneShopiterm(itermid));
    }

}
