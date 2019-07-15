package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    @TableId
    private Integer detailId;
    private String detailOrder;
    private Integer detailGoods;
    private Double detailPrice;
    private Integer detailNum;


    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }


    public String getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(String detailOrder) {
        this.detailOrder = detailOrder;
    }


    public Integer getDetailGoods() {
        return detailGoods;
    }

    public void setDetailGoods(Integer detailGoods) {
        this.detailGoods = detailGoods;
    }


    public Double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(Double detailPrice) {
        this.detailPrice = detailPrice;
    }


    public Integer getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Integer detailNum) {
        this.detailNum = detailNum;
    }

    @Override
    public String toString() {
        return "订单详情编号："+detailId+
                "\n订单Id："+detailOrder+
                "\n子商品种类："+detailGoods+
                "\n子商品总价："+detailPrice+
                "\n子商品数量："+detailNum;
    }
}
