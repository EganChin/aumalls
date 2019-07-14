package com.mall.common.service;


import com.mall.common.domain.Order;
import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.order.OrderDetailVO;
import com.mall.common.vo.order.OrderVO;

import java.util.List;

/**
 * @author 10653
 * @date 2019/7/11
 */
public interface OrderService {

    /**
     * 根据用户id获取订单基本信息集和
     * @author 10653
     * @date  2019/7/11
     */
    PageWrapper getOrdersByUserId(int userId, QueryOrdersForm queryOrdersForm);

    /**
     * 根据订单id获取订单详情
     * @author 10653
     * @date 2019/7/11
     */
    OrderDetailVO getOrderDetail(String orderId);

    /**
     * 生成订单
     * @author 10653
     * @date 2019/7/11
     */
    void saveOrder(OrderDetailVO orderDetailVO);

    /**
     * 获取所有订单
     * @author 10653
     * @date 2019/7/13
     * @return List<OrderVO>
     */
    List<OrderVO> getAllOrders();

}
