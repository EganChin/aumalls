package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class OrderStatus {

    @TableId
    private Integer orderStatusId;
    private String orderStatusName;


    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }


    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

}
