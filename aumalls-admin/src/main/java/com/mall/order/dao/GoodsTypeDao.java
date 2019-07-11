package com.mall.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.GoodsType;
import com.mall.common.vo.goods.GoodsTypeVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/10 15:08
 **/
public interface GoodsTypeDao extends BaseMapper<GoodsType> {

    @Select("select type_id, type_name from goods_type ${ew.customSqlSegment}")
    List<GoodsTypeVO> selectVOList(@Param("ew")Wrapper wrapper);

}
