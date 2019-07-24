package com.mall.consumer.service.impl;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.GoodsTypeVO;
import com.mall.common.vo.goods.QueryGoodsVO;
import com.mall.consumer.service.GoodsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author egan
 * @date 2019/7/24 14:58
 * @desc Hytrix错误处理实现类
 */
@Component
public class HystrixService implements GoodsService {
    @Override
    public PageWrapper<QueryGoodsVO> getPage(QueryGoodsForm form) {
        return null;
    }

    @Override
    public List<GoodsTypeVO> getSeniorTypes() {
        return null;
    }
}
