package com.mall.admin.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.User;

/**
 * Created by zzy on 2019/7/14.
 */
public interface UserAdminDao extends BaseMapper<User>{

    Page<User> selectUserPage(Page<User> userPage);
}
