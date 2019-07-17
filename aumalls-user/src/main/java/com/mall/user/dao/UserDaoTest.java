package com.mall.user.dao;

import com.mall.common.domain.User;
import com.mall.common.service.UserService;
import com.mall.user.Application;

import com.mall.user.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Resource
    private UserService userService;
    @Test
    public void modifyUserinfo() {

        int b=8;
        String a="qq";
        String c="bb";
        User user=new User();
        user.setUserPhone(a);
        user.setUserPass(c);
         userService.modifyUserPass(user);
//        for(int i = 0;i < a.size();i++){
//            System.out.println(a.get(i));
//        }
    }
}
