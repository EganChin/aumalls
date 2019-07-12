package com.mall.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.domain.Goods;
import com.mall.common.domain.Shopitem;
import com.mall.common.service.IUserShopCartService;
import com.mall.common.vo.shoppingcart.ShoppingCartItem;
import com.mall.goods.dao.GoodsDao;
import com.mall.goods.dao.ShopItermDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/7/11.
 */
@Service
@org.springframework.stereotype.Service
public class UserCartService implements IUserShopCartService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private ShopItermDao shopItermDao;

    /**
     * @param userId   用户
     * @param goodsNum 商品数量
     * @param goodsId  商品
     * @return 返回 -1代表用户不存在， 否则返回生成的主键值
     */
    @Override
    public int userJoinShopCart(int userId, int goodsNum, int goodsId) {

        Goods goods = getGoodsInShopcart(goodsId);

        if (goods == null) {
            return -1;
        }

        Shopitem shopitem = new Shopitem();

        shopitem.setItemNum(goodsNum);
        shopitem.setItemPrice(goodsNum * goods.getGoodsPrice());
        shopitem.setItemGoods(goodsId);
        shopitem.setItemUser(userId);

        shopItermDao.insert(shopitem);

        return shopitem.getItemId();
    }

    @Override
    public List<ShoppingCartItem> getUserShoppingIterms(int userId) {

        List<ShoppingCartItem> shoppingCartItems = shopItermDao.getAllShopCartIterms(userId);

        return shoppingCartItems;
    }

    @Override
    public int updateShoppingItermNum(int itermId, int goodsNum) {

        Shopitem shopitem = shopItermDao.selectById(itermId);
        if (shopitem == null) {
            return -1;
        }

        Goods goods = getGoodsInShopcart(shopitem.getItemGoods());
        if (goods == null) {
            return -2;
        }
        shopitem.setItemNum(goodsNum);
        shopitem.setItemPrice(goodsNum * goods.getGoodsPrice());

        int i = shopItermDao.updateById(shopitem);

        return i;
    }

    @Override
    public Goods getGoodsInShopcart(int goodsId) {

        QueryWrapper<Goods> queryWrapper = new QueryWrapper();
        queryWrapper.eq("goods_id", goodsId).eq("goods_state", 1);

        return goodsDao.selectOne(queryWrapper);
    }

    @Override
    public int flushCart(int userId) {
        QueryWrapper<Shopitem> shopitemQueryWrapper = new QueryWrapper<>();

        shopitemQueryWrapper.eq("item_user", userId);

        return shopItermDao.delete(shopitemQueryWrapper);
    }

    @Override
    public int flushOneShopiterm(int iterm) {
        return shopItermDao.deleteById(iterm);

    }


}
