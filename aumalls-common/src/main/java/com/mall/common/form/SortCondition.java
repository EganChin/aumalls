package com.mall.common.form;

import java.io.Serializable;

/**
 * 排序条件表单
 * @author Egan
 * @date 2019/7/9 14:16
 **/
public class SortCondition implements Serializable{

    private String name;

    private Boolean asc = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAsc() {
        return asc;
    }

    public void setAsc(Boolean asc) {
        this.asc = asc;
    }
}
