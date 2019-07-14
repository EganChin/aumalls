package com.mall.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Order;
import com.mall.common.domain.OrderDetail;
import com.mall.common.domain.OrderRecipient;
import com.mall.common.domain.OrderStatus;
import com.mall.common.vo.order.OrderStatusVO;
import com.mall.common.vo.order.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10653
 * @date 2019/7/14
 */
public interface OrderDao extends BaseMapper<Order> {

    @Select("select order_id from `order`")
    List<OrderVO> selectAllOrders();

    @Select("select * from `order` ${ew.customSqlSegment}")
    List<OrderVO> selectOrderPage(Page page, @Param("ew") Wrapper wrapper);

    @Select("select * from `order` ${ew.customSqlSegment}")
    OrderVO selectOrderByOrderId(@Param("ew") Wrapper wrapper);

    @Select("select * from order_detail ${ew.customSqlSegment}")
    List<OrderDetail> selectODByOrderId(@Param("ew") Wrapper wrapper);

    @Select("select * from order_status ${ew.customSqlSegment}")
    OrderStatusVO selectStatusName(@Param("ew") Wrapper wrapper);

}
