package com.mall.entity;


public class Orders {

  private String orderId;
  private Integer orderUser;
  private String orderAddress;
  private String orderPhone;
  private String orderName;
  private Integer orderStatus;
  private double orderPrice;
  private java.sql.Timestamp orderTime;


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


  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public java.sql.Timestamp getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(java.sql.Timestamp orderTime) {
    this.orderTime = orderTime;
  }

}
