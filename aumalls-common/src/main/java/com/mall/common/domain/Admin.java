package com.mall.common.domain;


public class Admin {

  private Integer adminId;
  private String adminName;
  private String adminPass;
  private Integer adminRole;


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPass() {
    return adminPass;
  }

  public void setAdminPass(String adminPass) {
    this.adminPass = adminPass;
  }


  public Integer getAdminRole() {
    return adminRole;
  }

  public void setAdminRole(Integer adminRole) {
    this.adminRole = adminRole;
  }

}
