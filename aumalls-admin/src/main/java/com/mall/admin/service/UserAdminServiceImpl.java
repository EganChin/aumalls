package com.mall.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.domain.User;
import com.mall.common.service.IUserAdminService;
import com.mall.common.utils.PageWrapper;

/**
 * Created by zzy on 2019/7/14.
 */
public class UserAdminServiceImpl implements IUserAdminService{

    @Override
    public PageWrapper<User> getAllUsersForPages() {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        //userQueryWrapper.eq()


        return null;
    }

    @Override
    public int updateUserDisableTime(int userid, String time) {
        return 0;
    }
}
