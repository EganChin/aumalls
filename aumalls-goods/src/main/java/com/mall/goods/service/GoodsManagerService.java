package com.mall.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.domain.Goods;
import com.mall.common.service.IGoodsManagerService;
import com.mall.goods.dao.GoodsManagerDao;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@org.springframework.stereotype.Service
public class GoodsManagerService implements IGoodsManagerService {

    @Resource
    private GoodsManagerDao goodsManagerDao;
    @Override
    public List<Goods> getGoodsByStateE0() {
        List<Goods> goods = new ArrayList<Goods>();
        goods=goodsManagerDao.getGoodsByState0();
        return goods;
    }

    @Override
    public List<Goods> getGoodsByStateE1() {
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

}
