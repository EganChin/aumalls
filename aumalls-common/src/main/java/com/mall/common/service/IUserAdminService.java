package com.mall.common.service;

import com.mall.common.domain.User;
import com.mall.common.utils.PageWrapper;

import java.util.List;

/**
 * Created by zzy on 2019/7/12.
 */
public interface IUserAdminService {

    /**
     * 得到所有用户，分页显示
     * @return
     */
    public PageWrapper<User> getAllUsersForPages();

    /**
     *
     * @param userid 用户ID
     * @param time 用户禁用停止时间
     * @return
     */
    public int updateUserDisableTime(int userid, String time);


}
