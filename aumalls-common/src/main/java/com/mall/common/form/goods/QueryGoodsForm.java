package com.mall.common.form.goods;

import com.mall.common.form.SortCondition;
import com.mall.common.utils.Query;

import java.io.Serializable;
import java.util.List;

/**
 * 商品分页查询表单
 * @author Egan
 * @date 2019/7/9 14:15
 **/
public class QueryGoodsForm extends Query implements Serializable{

    private List<SortCondition> sorts;

    private Integer type;

    private Float maxPrice;

    private Float minPrice;

    public List<SortCondition> getSorts() {
        return sorts;
    }

    public void setSorts(List<SortCondition> sorts) {
        this.sorts = sorts;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }
}
