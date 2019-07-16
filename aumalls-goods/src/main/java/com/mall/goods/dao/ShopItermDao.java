package com.mall.goods.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.Shopitem;
import com.mall.common.vo.shoppingcart.ShoppingCartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzy on 2019/7/11.
 */
public interface ShopItermDao extends BaseMapper<Shopitem>{


    List<ShoppingCartItem> getAllShopCartIterms(@Param("userId") int userId);

    void updateItermNum();

    int updateItermByGoodsAndUserID(@Param("userId") int userId, @Param("goodsId") int goodsId, @Param("goodsNum") int goodsNum, @Param("price") double goodsPrice);
}
