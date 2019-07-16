package com.mall.admin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.admin.dao.UserAdminDao;
import com.mall.common.domain.User;
import com.mall.common.service.IUserAdminService;
import com.mall.common.utils.DateUtils;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.user.UserAdminVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zzy on 2019/7/14.
 */
@Service(interfaceName = "com.mall.common.service.IUserAdminService", timeout = 3000)
@org.springframework.stereotype.Service
public class UserAdminServiceImpl implements IUserAdminService {

    @Resource
    private UserAdminDao userAdminDao;

    @Override
    public PageWrapper<UserAdminVO> getAllUsersForPages(int pageSize, int pageNum) {

        Page<User> userPage = new Page<>(pageNum, pageSize);
        PageWrapper<UserAdminVO> userPageWrapper = new PageWrapper<>();

        userAdminDao.selectUserPage(userPage);

        List<UserAdminVO> userAdminVOS = new ArrayList<>();

        for (User user:userPage.getRecords()){
            UserAdminVO temp = new UserAdminVO();
            temp.setUserId(user.getUserId());
            temp.setUserAddress(user.getUserAddress());
            temp.setUserPhone(user.getUserPhone());
            temp.setUserName(user.getUserName());
            String format = DateUtils.format(user.getUserWhitetime(), "yyyy-MM-dd HH:mm");
            String t = format.replace(" ", "T");
            System.out.println(t);
            temp.setUserWhitetime(t);
            userAdminVOS.add(temp);
        }


        userPageWrapper.setList(userAdminVOS);
        userPageWrapper.setTotal(userPage.getTotal());
        userPageWrapper.setPn(new Long(pageNum));

        userPageWrapper.setPs(new Long(pageSize));

        return userPageWrapper;
    }

    @Override
    public int updateUserDisableTime(int userid, Long time) {
        User user = new User();
        user.setUserId(userid);
        user.setUserWhitetime(time);
        return userAdminDao.updateById(user);
    }


}
