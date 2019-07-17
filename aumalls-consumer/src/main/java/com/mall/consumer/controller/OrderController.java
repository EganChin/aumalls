package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.service.OrderService;
import com.mall.common.utils.PageWrapper;
import com.mall.common.utils.R;
import com.mall.common.validator.ValidatorUtils;
import com.mall.common.vo.order.OrderDetailVO;
import com.mall.common.vo.order.OrderVO;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10653
 * date 2019/7/14
 */

@Controller
@RequestMapping("order")
@RequiresRoles("ADMIN")
public class OrderController extends  BaseController{

//    @Reference
    private OrderService orderService;

    @RequestMapping("order")
    public String order(){
        return "order";
    }

    @ResponseBody
    @RequestMapping(value = "ordersPage", method = RequestMethod.GET)
    public R getPage(QueryOrdersForm form){

        ValidatorUtils.validate(form);

        int userId=getUser().getUserId();
        System.out.println("订单查询————用户id为:"+userId);
        PageWrapper pw=orderService.getOrdersByUserId(userId,form);
        List<OrderVO> list=pw.getList();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println("----第"+(i+1)+"个订单----");
            System.out.println(list.get(i).toString());
        }
        return R.ok().put("page", pw);
    }

    @ResponseBody
    @RequestMapping("orderDetail")
    public R getOrderDetail(@RequestParam("orderId")String orderId){

        OrderDetailVO orderDetailVO = orderService.getOrderDetail(orderId);

        System.out.println("获取对象结果：\t"+orderDetailVO);

        return R.ok().put("orderDetail",orderDetailVO);
    }
}
