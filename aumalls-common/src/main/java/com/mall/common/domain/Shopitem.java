package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class Shopitem {

    @TableId
    private Integer itemId;
    private Integer itemGoods;
    private Double itemPrice;
    private Integer itemNum;
    private Integer itemUser;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public Integer getItemGoods() {
        return itemGoods;
    }

    public void setItemGoods(Integer itemGoods) {
        this.itemGoods = itemGoods;
    }


    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }


    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }


    public Integer getItemUser() {
        return itemUser;
    }

    public void setItemUser(Integer itemUser) {
        this.itemUser = itemUser;
    }

}
