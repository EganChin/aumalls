package com.mall.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Goods;
import com.mall.common.form.goods.ManagerGoodsForm;
import com.mall.common.service.IGoodsManagerService;
import com.mall.common.utils.PageWrapper;
import com.mall.common.utils.Query;
import com.mall.common.vo.goods.ApplyGoodsVO;
import com.mall.goods.dao.GoodsManagerDao;
import org.springframework.cache.annotation.CacheEvict;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(interfaceName = "com.mall.common.service.IGoodsManagerService")
@org.springframework.stereotype.Service
public class GoodsManagerServiceImpl implements IGoodsManagerService {

    @Resource
    private GoodsManagerDao goodsManagerDao;
    @Override
    public PageWrapper<ApplyGoodsVO> getGoodsByStateE0(ManagerGoodsForm query) {
        System.out.println("query.ps:"+query.getPs());
        List<ApplyGoodsVO> goods = new ArrayList<>();
        System.out.println("goodsSize:"+goods.size()+"\t<br>+queryTotal:"+query.getTotal());
//        query.setTotal(goods.size());
        Page page = new Page(query.getPn(), query.getPs());
        goods=goodsManagerDao.getGoodsByState0(page);
        return new PageWrapper<>(page,goods);
    }

    @Override
    public PageWrapper<ApplyGoodsVO> getGoodsByStateE1(ManagerGoodsForm query) {
        Page page = new Page(query.getPn(),query.getPs());
        List<ApplyGoodsVO> goods = new ArrayList<>();
        goods = goodsManagerDao.getAllGoodsState1(page);
        return new PageWrapper<>(page,goods);
    }

    @CacheEvict(value = "goods-cache", allEntries = true)
    @Override
    public int updateGoodsState(Integer id) {
        return goodsManagerDao.updateGoodsState(id);
    }

    @CacheEvict(value = "goods-cache", allEntries = true)
    @Override
    public int updateGoodsStateTo0(Integer id) {

        return goodsManagerDao.updateGoodsStateTo0(id);
    }

    @Override
    public int getUserCount() {
        return goodsManagerDao.getUserCount();
    }

    @CacheEvict(value = "goods-cache", allEntries = true)
    @Override
    public void deleteGoodsById(int id) {
        goodsManagerDao.deleteGoods(id);
    }

    @CacheEvict(value = "goods-cache", allEntries = true)

    @Override
    public List<Goods> getGoodsInfoById(int id) {
        return goodsManagerDao.getGoodsInfoById(id);
    }

}
