package com.mall.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.api.domain.GoodsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.service.IGoodsService;
import com.mall.common.utils.PageWrapper;
import com.mall.goods.dao.GoodsDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Egan
 * @date 2019/7/9 22:49
 **/
@Service
@org.springframework.stereotype.Service
public class GoodService implements IGoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public PageWrapper getPage(QueryGoodsForm form) {
        Page page = new Page(form.getPn(), form.getPs());

        List<GoodsVO> list = goodsDao.selectGoodsPage(page, new QueryWrapper<>());

        return new PageWrapper<>(page, list);
    }
}
