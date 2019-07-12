package com.mall.common.vo.shoppingcart;

import java.io.Serializable;

/**
 * Created by zzy on 2019/7/11.
 */
public class ShoppingCartItem implements Serializable{

    private Integer itermId;

    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    private String goodsName;

    private String goodsImgPath;

    private String goodsNum;

    private double goodsTotalPrice;

    public Integer getItermId() {
        return itermId;
    }

    public void setItermId(Integer itermId) {
        this.itermId = itermId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImgPath() {
        return goodsImgPath;
    }

    public void setGoodsImgPath(String goodsImgPath) {
        this.goodsImgPath = goodsImgPath;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public ShoppingCartItem(Integer itermId, String goodsName, String goodsImgPath, String goodsNum, double goodsTotalPrice) {
        this.itermId = itermId;
        this.goodsName = goodsName;
        this.goodsImgPath = goodsImgPath;
        this.goodsNum = goodsNum;
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public ShoppingCartItem() {
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "itermId=" + itermId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImgPath='" + goodsImgPath + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsTotalPrice=" + goodsTotalPrice +
                '}';
    }
}
