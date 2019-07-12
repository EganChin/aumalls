package test;

import com.mall.goods.Application;
import com.mall.goods.service.UserCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by zzy on 2019/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestShopcart {

    @Resource
    private UserCartService userCartService;

    @Test
    public void test01(){

        int i = userCartService.addUserShopItermCart(1, 1, 12);

        System.out.println(i);


    }

    @Test
    public void test02(){

        System.out.println(userCartService.getUserShoppingIterms(1));

    }

    @Test
    public void test03(){

        System.out.println(userCartService.updateShoppingItermNum(1, 3));

    }

    @Test
    public void test04(){

        System.out.println(userCartService.getGoodsInShopcart(3));

    }

    @Test
    public void test05(){

        System.out.println(userCartService.updateFlushCart(2));

    }

    @Test
    public void test06(){

        System.out.println(userCartService.updateFlushOneShopiterm(4));

    }




}
