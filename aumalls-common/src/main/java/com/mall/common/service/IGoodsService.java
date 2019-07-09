package com.mall.common.service;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;

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
    PageWrapper getPage(QueryGoodsForm form);

}
