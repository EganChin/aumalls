package com.mall.consumer.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.service.IGoodsService;
import com.mall.common.utils.PageWrapper;


/**
 * @author Egan
 * @date 2019/7/9 14:40
 **/
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class GoodsService implements IGoodsService {

    @Override
    public PageWrapper getPage(QueryGoodsForm form) {
        return null;
    }
}
