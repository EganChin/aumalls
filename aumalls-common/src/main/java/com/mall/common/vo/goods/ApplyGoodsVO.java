package com.mall.common.vo.goods;

import com.mall.common.domain.Goods;

import java.io.Serializable;

public class ApplyGoodsVO extends Goods implements Serializable {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
