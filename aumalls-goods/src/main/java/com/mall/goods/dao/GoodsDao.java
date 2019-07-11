package com.mall.goods.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.vo.goods.QueryGoodsVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/9 22:48
 **/
public interface GoodsDao {

    @Select("select goods_id, goods_name, goods_price, goods_num, goods_img from goods ${ew.customSqlSegment}")
    List<QueryGoodsVO> selectGoodsPage(Page page, @Param("ew")Wrapper wrapper);

}
