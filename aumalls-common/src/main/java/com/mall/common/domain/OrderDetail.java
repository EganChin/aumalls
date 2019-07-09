package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class OrderDetail {

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

}
