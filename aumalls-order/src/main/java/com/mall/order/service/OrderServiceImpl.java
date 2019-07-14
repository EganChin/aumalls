package com.mall.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Order;
import com.mall.common.domain.OrderDetail;
import com.mall.common.domain.OrderStatus;
import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.order.OrderDetailVO;
import com.mall.common.vo.order.OrderVO;
import com.mall.order.dao.OrderDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10653
 * @date 2019/7/13
 */
@Service(interfaceName = "com.mall.common.service.OrderService")
@org.springframework.stereotype.Service
public class OrderServiceImpl implements com.mall.common.service.OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 根据用户id获取订单分页
     * @param userId
     * @param queryOrdersForm
     * @return PageWrapper
     */
    @Override
    public PageWrapper getOrdersByUserId(int userId, QueryOrdersForm queryOrdersForm) {

        Page page = new Page(queryOrdersForm.getPn(),queryOrdersForm.getPs());

        QueryWrapper<OrderVO> orderWrapper = new QueryWrapper<>();

        orderWrapper.eq("order_user",userId);

        if(queryOrdersForm.getStatus()>=1&&queryOrdersForm.getStatus()<=5) {//如果状态在设定范围内
            orderWrapper.eq("order_status", queryOrdersForm.getStatus());
        }

        List<OrderVO> orderList=orderDao.selectOrderPage(page,orderWrapper);

        return new PageWrapper<>(page,orderList);
    }

    @Override
    public OrderDetailVO getOrderDetail(String orderId) {

        OrderDetailVO orderDetailVO = new OrderDetailVO();

        QueryWrapper<Order> orderWrapper=new QueryWrapper<>();
        orderWrapper.eq("order_id",orderId);
        Order order=orderDao.selectOrderByOrderId(orderWrapper);

        if(order!=null) {
            QueryWrapper<OrderDetail> ODWrapper = new QueryWrapper<>();
            QueryWrapper<OrderStatus> ORWrapper = new QueryWrapper<>();

            ODWrapper.eq("detail_order", orderId);
            ORWrapper.eq("order_status_id", order.getOrderStatus());

            List<OrderDetail> orderDetails = orderDao.selectODByOrderId(ODWrapper);
            OrderStatus orderStatus = orderDao.selectStatusName(ORWrapper);

            orderDetailVO.setOrder(order);
            orderDetailVO.setOrderStatusName(orderStatus.getOrderStatusName());
            orderDetailVO.setOrderDetails(orderDetails);
        }

        return orderDetailVO;
    }

    @Override
    public void saveOrder(OrderDetailVO orderDetailVO) {

    }

    @Override
    public List<OrderVO> getAllOrders() {
        return orderDao.selectAllOrders();
    }
}
