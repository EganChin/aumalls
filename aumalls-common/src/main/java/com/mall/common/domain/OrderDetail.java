package com.mall.common.domain;


public class OrderDetail {

  private Integer detailId;
  private String detailOrder;
  private Integer detailGoods;
  private double detailPrice;
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


  public double getDetailPrice() {
    return detailPrice;
  }

  public void setDetailPrice(double detailPrice) {
    this.detailPrice = detailPrice;
  }


  public Integer getDetailNum() {
    return detailNum;
  }

  public void setDetailNum(Integer detailNum) {
    this.detailNum = detailNum;
  }

}
