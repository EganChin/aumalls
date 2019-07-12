package com.mall.common.service;

import com.mall.common.domain.Goods;
import com.mall.common.vo.shoppingcart.ShoppingCartItem;

import java.util.List;

/**
 * Created by zzy on 2019/7/11.
 */
public interface IUserShopCartService {

    /**
     * 用户添加至购物车
     * @param userId 用户
     * @param goodsNum 商品数量
     * @param goodsId  商品
     * @return 返回生成的ItermID
     */
    int userJoinShopCart(int userId, int goodsNum, int goodsId);

    /**
     *
     * @param userId 用户Id
     * @return 购物车每一项的集合
     */
    List<ShoppingCartItem> getUserShoppingIterms(int userId);

    /**
     * 更新购物车商品数量
     * @param itermId 购物车每一项的ID
     * @param goodsNum 商品 数量
     * @return 0 代表数量更新成功 。1 代表数量更新失败。2 代表 数量为1禁止更新
     */
     int updateShoppingItermNum(int itermId, int goodsNum);


    /**
     *
     * @param goodsId 商品ID
     * @return 返回查询到的商品
     */
     Goods getGoodsInShopcart(int goodsId);

    /**
     *
     * 清空购物车
     * @param userId 用户Id
     */
      int flushCart(int userId);

    /**
     * 移除购物车某一项
     * @param iterm
     * @return
     */
      int flushOneShopiterm(int iterm);

}
