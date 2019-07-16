package com.mall.common.service;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.mall.common.domain.Goods;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.ApplyGoodsVO;

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
    PageWrapper<ApplyGoodsVO> getGoodsByStateE0(ManagerGoodsForm query);

    /**
     * 查询
     * @date2019/7/13
     * @return 商品上架状态为1的所有商品信息
     */
    List<Goods> getGoodsByStateE1(ManagerGoodsForm query);

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

    /**
     * 查询注册用户数
     * @return
     */
    int getUserCount();

    /**
     * 拒绝上架物，彻底删除
     * @param id
     */
    void deleteGoodsById(int id);
}
