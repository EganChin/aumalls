package com.mall.common.service;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.GoodsTypeVO;
import com.mall.common.vo.goods.QueryGoodsVO;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/9 14:12
 **/
public interface IGoodsService {

    /**
     * 获取商品分页
     * @date 2019/7/9 14:15
     * @param form
     **/
    PageWrapper<QueryGoodsVO> getPage(QueryGoodsForm form);

    /**
     * 获取所有一级和二级商品类型
     * @date 2019/7/10 15:04
     * @param
     **/
    List<GoodsTypeVO> getSeniorTypes();
}
