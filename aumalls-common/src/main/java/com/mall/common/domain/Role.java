package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class Role {

    @TableId
    private Integer roleId;
    private String roleName;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
