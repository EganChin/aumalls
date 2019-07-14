package com.mall.common.form.order;

import com.mall.common.utils.Query;

import java.io.Serializable;

public class QueryOrdersForm extends Query implements Serializable {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
