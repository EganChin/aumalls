package com.mall.common.service;

import com.mall.common.domain.Goods;

import java.util.List;

/**
 * @author CCX
 * @date 2019/7/12
 */
public interface IGoodsManagerService {
    /**
     * 查询
     * @date 2019/7/12
     * @return 商品上架状态为0的所有商品信息
     */
    List<Goods> getGoodsByStateE0();

    /**
     * 查询
     * @date2019/7/13
     * @return 商品上架状态为1的所有商品信息
     */
    List<Goods> getGoodsByStateE1();

    /**
     * 更新商品状态为1，即上架商品
     * @return
     */
    int updateGoodsState(Integer id);
    /**
     * 更新商品状态为0，即下架商品
     * @return
     */
    int updateGoodsStateTo0(List ids);
}
