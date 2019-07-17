package com.mall.common.vo.order;

import com.mall.common.domain.OrderDetail;

import java.io.Serializable;

public class OrderGoodsVO extends OrderDetail implements Serializable {
    private String goodsName;
    private String goodsImg;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
