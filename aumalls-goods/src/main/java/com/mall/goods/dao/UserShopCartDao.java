package com.mall.goods.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by zzy on 2019/7/11.
 */
public interface UserShopCartDao {

    public int joinShopcart(@Param("userId") int userId, @Param("goodsNum") int goodsNum, @Param("goodsId") int goodsId);


}
