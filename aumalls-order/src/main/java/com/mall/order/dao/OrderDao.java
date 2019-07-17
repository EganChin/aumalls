package com.mall.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Order;
import com.mall.common.domain.OrderDetail;
import com.mall.common.domain.OrderRecipient;
import com.mall.common.domain.OrderStatus;
import com.mall.common.vo.order.OrderDetailVO;
import com.mall.common.vo.order.OrderGoodsVO;
import com.mall.common.vo.order.OrderStatusVO;
import com.mall.common.vo.order.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10653
 * @date 2019/7/17
 */
public interface OrderDao extends BaseMapper<Order> {

    //返回所有订单信息
    @Select("select * from `order`")
    List<OrderVO> selectAllOrders();

    @Select("select count(*) from  `order` ${ew.customSqlSegment}")
    int selectOrderSum(@Param("ew") Wrapper wrapper);

    //返回订单页
    @Select("select * from `order` ${ew.customSqlSegment}")
    List<OrderVO> selectOrderPage(Page page, @Param("ew") Wrapper wrapper);

    //根据订单id返回订单信息
    @Select("select * from `order` ${ew.customSqlSegment}")
    OrderVO selectOrderByOrderId(@Param("ew") Wrapper wrapper);

    /*@Select("select * from order_detail ${ew.customSqlSegment}")
    List<OrderDetail> selectODByOrderId(@Param("ew") Wrapper wrapper);*/

    //返回订单货物信息
    @Select("SELECT\n" +
            "order_detail.detail_id,\n" +
            "order_detail.detail_order,\n" +
            "order_detail.detail_goods,\n" +
            "order_detail.detail_price,\n" +
            "order_detail.detail_num,\n" +
            "goods.goods_name,\n" +
            "goods.goods_img\n"+
            "FROM\n" +
            "order_detail\n" +
            "INNER JOIN goods ON order_detail.detail_goods = goods.goods_id ${ew.customSqlSegment}")
    List<OrderGoodsVO> selectODByOrderId(@Param("ew") Wrapper wrapper);

    //返回订单状态字
    @Select("select * from order_status ${ew.customSqlSegment}")
    OrderStatusVO selectStatusName(@Param("ew") Wrapper wrapper);

    //根据订单号返回订单第一个商品图片
    @Select("SELECT\n" +
            "goods.goods_img\n" +
            "FROM\n" +
            "order_detail\n" +
            "INNER JOIN goods ON order_detail.detail_goods = goods.goods_id ${ew.customSqlSegment}\n" +
            "LIMIT 1")
    OrderGoodsVO selectImgByOrderId(@Param("ew") Wrapper wrapper);
}
