package com.mall.admin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.admin.dao.AdminDao;
import com.mall.common.config.AuthConfig;
import com.mall.common.domain.Admin;
import com.mall.common.domain.Operator;
import com.mall.common.exception.RRException;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.AdminService;
import com.mall.common.utils.HashUtils;
import com.mall.common.utils.RedisWrapper;
import com.mall.common.vo.user.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author Egan
 * @date 2019/7/10 10:08
 **/
@Service(timeout = 5000, interfaceName = "com.mall.common.service.AdminService")
@org.springframework.stereotype.Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RedisWrapper redisWrapper;

    @Resource
    private AdminDao adminDao;

    @Autowired
    private AuthConfig configuration;

    @Override
    public LoginVO adminLogin(LoginForm form) {
        QueryWrapper<Admin> ew = new QueryWrapper<Admin>()
            .eq("admin_pass",  form.getPassword())
            .eq("admin_name", form.getAccount());
        Admin admin = adminDao.selectOne(ew);

        if (admin != null) {
            // 生成临时身份令牌
            String token = HashUtils.md5Digest(form.getAccount() + System.currentTimeMillis());
            redisWrapper.value().set(token, new Operator(admin), configuration.getTimeout());

            redisWrapper.addToken(admin.getAdminId(), token);

            return new LoginVO(admin, token);

        }

        throw new RRException("账号和密码不一致");
    }
}
