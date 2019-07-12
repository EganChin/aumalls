package com.mall.goods.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CCX
 * @date 2019/7/12
 */
@Repository
public interface GoodsManagerDao extends BaseMapper<Goods> {
    public List<Goods> getGoodsByState0();

}
