package com.mall.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Goods;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.service.IGoodsManagerService;
import com.mall.common.utils.PageWrapper;
import com.mall.common.utils.Query;
import com.mall.goods.dao.GoodsManagerDao;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@org.springframework.stereotype.Service
public class GoodsManagerServiceImpl implements IGoodsManagerService {

    @Resource
    private GoodsManagerDao goodsManagerDao;
    @Override
    public PageWrapper<Goods> getGoodsByStateE0(ManagerGoodsForm query) {
        Page page = new Page(query.getPn(),6);
        List<Goods> goods = new ArrayList<Goods>();
        goods=goodsManagerDao.getGoodsByState0();
        return new PageWrapper<>(page,goods);
    }

    @Override
    public List<Goods> getGoodsByStateE1(ManagerGoodsForm query) {
        QueryWrapper<Goods> queryWrapper=new QueryWrapper();
        queryWrapper.eq("goods_state",1);
        return goodsManagerDao.selectList(queryWrapper);
    }

    @Override
    public int updateGoodsState(Integer id) {
        return goodsManagerDao.updateGoodsState(id);
    }

    @Override
    public int updateGoodsStateTo0(List ids) {

        return goodsManagerDao.updateGoodsStateTo0(ids);
    }

    @Override
    public int getUserCount() {
        return goodsManagerDao.getUserCount();
    }

}
