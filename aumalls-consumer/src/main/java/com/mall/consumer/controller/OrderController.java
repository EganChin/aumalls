package com.mall.consumer.controller;

import com.mall.common.form.order.QueryOrdersForm;
import com.mall.common.service.OrderService;
import com.mall.common.utils.PageWrapper;
import com.mall.common.utils.R;
import com.mall.common.validator.ValidatorUtils;
import com.mall.common.vo.order.OrderDetailVO;
import com.mall.common.vo.order.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author 10653
 * date 2019/7/14
 */

@Controller
@RequestMapping("order")
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
        //System.out.println("订单查询————用户id为:"+userId);
        PageWrapper pw=orderService.getOrdersByUserId(userId,form);
        List<OrderVO> list=pw.getList();
        /*for (int i = 0; i <list.size() ; i++) {
            System.out.println("----第"+(i+1)+"个订单----");
            System.out.println(list.get(i).toString());
        }*/
        return R.ok().put("page", pw);
    }

    @RequestMapping("orderDetail")
    public String  getOrderDetail(Map<String, Object> model,@RequestParam("orderId")String orderId){

        OrderDetailVO orderDetailVO = orderService.getOrderDetail(orderId);

        //System.out.println("获取对象结果：\t"+orderDetailVO);

        model.put("orderDetail",orderDetailVO);

        return "orderDetail";
    }

    @ResponseBody
    @RequestMapping("orderSum")
    public R getOrderSum(@RequestParam("status")int status){
        int userId=getUser().getUserId();
        int orderSum=orderService.getOrderSum(userId,status);
        System.out.println("订单数为："+orderSum);
        return R.ok().put("orderSum",orderSum);
    }
}
