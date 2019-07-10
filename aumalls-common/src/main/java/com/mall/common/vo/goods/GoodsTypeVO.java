package com.mall.common.vo.goods;

import java.io.Serializable;
import java.util.List;

/**
 * @author Egan
 * @date 2019/7/10 14:58
 **/
public class GoodsTypeVO implements Serializable{

    private String typeId;

    private String typeName;

    private List<GoodsTypeVO> children;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<GoodsTypeVO> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTypeVO> children) {
        this.children = children;
    }
}
