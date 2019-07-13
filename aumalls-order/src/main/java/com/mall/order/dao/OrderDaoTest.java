package com.mall.order.dao;

import com.mall.common.domain.Order;
import javax.annotation.Resource;
import java.util.List;

import com.mall.common.vo.order.OrderVO;
import com.mall.order.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderDaoTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void OrderTest(){
        List<OrderVO> orderList=orderDao.selectAllOrders();
        if(orderList==null){
            System.out.println("search failed");
        }else {
            for (int i = 0; i < orderList.size(); i++) {
                System.out.println(orderList.get(i).getOrderId());
            }
        }
    }
}
