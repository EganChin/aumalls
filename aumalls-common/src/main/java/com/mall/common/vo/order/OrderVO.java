package com.mall.common.vo.order;

import com.mall.common.domain.Order;

import java.io.Serializable;

public class OrderVO extends Order implements Serializable {

    private String goodsImg;

    @Override
    public String toString() {
        return "订单id：" + this.getOrderId() +
                "\n订单地址：" + this.getOrderAddress() +
                "\n订单名称：" + this.getOrderName() +
                "\n订单电话：" + this.getOrderPhone() +
                "\n订单价格："+this.getOrderPrice()+
                "\n订单状态："+this.getOrderStatus()+
                "\n订单时间："+this.getOrderTime()+
                "\n订单人id："+this.getOrderUser();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
