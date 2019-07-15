package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.service.OrderService;
import com.mall.common.utils.R;
import com.mall.common.vo.order.OrderDetailVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 10653
 * date 2019/7/14
 */

@RestController
@RequestMapping("order")
public class OrderController extends  BaseController{

    @Reference
    private OrderService orderService;

    @RequestMapping(value = "ordersPage", method = RequestMethod.GET)
    public R getPage(QueryOrdersForm form){
        int userId=getUser().getUserId();
        return R.ok().put("page", orderService.getOrdersByUserId(userId,form));
    }

    @RequestMapping("orderDetail")
    public R getOrderDetail(@RequestParam("orderId")String orderId){

        OrderDetailVO orderDetailVO = orderService.getOrderDetail(orderId);

        System.out.println("获取对象结果：\t"+orderDetailVO);

        return R.ok().put("orderDetail",orderDetailVO);
    }
}
