package test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.admin.Application;
import com.mall.admin.service.UserAdminServiceImpl;
import com.mall.common.domain.User;
import com.mall.common.utils.DateUtils;
import com.mall.common.utils.PageWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.unit.DataUnit;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zzy on 2019/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserAdmin {

    @Resource
    private UserAdminServiceImpl userAdminService;

    @Test
    public void test01(){
        //PageWrapper<User> allUsersForPages = userAdminService.getAllUsersForPages(3, 1);
        String format = DateUtils.format(new Date().getTime(), "yyyy-MM-dd HH:mm");
        String t = format.replace(" ", "T");
        System.out.println(t);



    }

    @Test
    public void testl02(){
        System.out.println(userAdminService.updateUserDisableTime(1, System.currentTimeMillis()));

    }





}
