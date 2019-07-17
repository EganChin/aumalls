package com.mall.common.vo.order;

import com.mall.common.domain.Order;
import com.mall.common.domain.OrderDetail;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 订单所有详细信息类
 * @author 10653
 * @date 2019/7/11
 */
public class OrderDetailVO implements Serializable {

    private String orderId;
    private Integer orderUser;
    private String orderAddress;
    private String orderPhone;
    private String orderName;
    private Integer orderStatus;
    private String orderStatusName;
    private double orderPrice;
    private Timestamp orderTime;

    List<OrderGoodsVO> orderDetails;

    public List<OrderGoodsVO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderGoodsVO> orderDetails) {
        this.orderDetails = orderDetails;
    }




    public void setOrder(Order order){
        this.orderId=order.getOrderId();
        this.orderUser=order.getOrderUser();
        this.orderAddress=order.getOrderAddress();
        this.orderPhone=order.getOrderPhone();
        this.orderName=order.getOrderName();
        this.orderStatus=order.getOrderStatus();
        this.orderPrice=order.getOrderPrice();
        this.orderTime=order.getOrderTime();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }



    @Override
    public String toString() {
        return "订单id："+orderId+
                "\n用户id："+orderUser+
                "\n订单地址："+orderAddress+
                "\n订单电话："+orderPhone+
                "\n订单名称："+orderName+
                "\n订单状态："+orderStatus+
                "\n订单价格："+orderPrice+
                "\n订单时间："+orderTime;
    }
}

