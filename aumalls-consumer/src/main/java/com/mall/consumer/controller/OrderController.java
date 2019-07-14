package com.mall.consumer.controller;

import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.utils.R;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mall.order.service.OrderServiceImpl;

/**
 * @author 10653
 * date 2019/7/14
 */

@RestController
@RequestMapping("order")
public class OrderController extends  BaseController{

    @Reference
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping(value = "ordersPage", method = RequestMethod.GET)
    public R getPage(QueryOrdersForm form){
        int userId=getUser().getUserId();
        return R.ok().put("page", orderServiceImpl.getOrdersByUserId(userId,form));
    }
}
