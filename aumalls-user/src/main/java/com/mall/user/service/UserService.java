package com.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.config.AuthConfig;
import com.mall.common.domain.User;
import com.mall.common.exception.RRException;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.IUserService;
import com.mall.common.utils.HashUtils;
import com.mall.common.utils.RedisWrapper;
import com.mall.common.vo.user.LoginVO;
import com.mall.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author Egan
 * @date 2019/7/10 10:08
 **/
@Service(timeout = 50000)
@org.springframework.stereotype.Service
public class UserService implements IUserService {


    @Autowired
    private RedisWrapper redisWrapper;

    @Resource
    private UserDao userDao;

    @Autowired
    private AuthConfig configuration;

    @Override
    public LoginVO login(LoginForm form) {

//        String ip = IPUtils.getIP();
//		if (!StringUtils.isBlank(ip)) {
//			Integer time = (Integer) valueOperations.get(RedisKey.LOGIN_ERROR + ip);
//			if (time != null && time >= 6) {
//				throw new RRException("登录失败超过6次，本日内无法登录");
//			}
//		}

        QueryWrapper<User> ew = new QueryWrapper<User>()
            .eq("user_pass",  form.getPassword())
            .and(w -> w.eq("user_name", form.getAccount())
                .or().eq("user_phone", form.getAccount()));
        User user = userDao.selectOne(ew);

        if (user != null) {
                // 生成临时身份令牌
                String token = HashUtils.md5Digest(form.getAccount() + System.currentTimeMillis());
                redisWrapper.value().set(token, user, configuration.getTimeout());

                redisWrapper.addToken(user.getUserId(), token);

                return new LoginVO(user, token);

        }

        throw new RRException("用户名或密码不一致");
    }
}
