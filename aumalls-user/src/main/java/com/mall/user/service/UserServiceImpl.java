package com.mall.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.config.AuthConfig;
import com.mall.common.domain.Operator;
import com.mall.common.domain.User;
import com.mall.common.exception.RRException;
import com.mall.common.form.user.LoginForm;
import com.mall.common.service.UserService;
import com.mall.common.utils.HashUtils;
import com.mall.common.utils.RedisWrapper;
import com.mall.common.vo.user.LoginVO;
import com.mall.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Egan
 * @date 2019/7/10 10:08
 **/
@Service(timeout = 5000, interfaceName = "com.mall.common.service.UserService")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisWrapper redisWrapper;

    @Resource
    private UserDao userDao;


    @Autowired
    private AuthConfig configuration;

    @Autowired
    private UserDao userMapper;

    @Override
    public LoginVO UserLogin(LoginForm form) {

//        String ip = IPUtils.getIP();
//		if (!StringUtils.isBlank(ip)) {
//			Integer time = (Integer) valueOperations.get(RedisKey.LOGIN_ERROR + ip);
//			if (time != null && time >= 6) {
//				throw new RRException("登录失败超过6次，本日内无法登录");
//			}
//		}

        QueryWrapper<User> ew = new QueryWrapper<User>()
            .eq("user_pass", form.getPassword())
            .and(w -> w.eq("user_name", form.getAccount())
                .or().eq("user_phone", form.getAccount()));
        User user = userDao.selectOne(ew);

        if (user != null) {
            if(user.getUserWhitetime() < System.currentTimeMillis())
                throw new RRException("您已被禁止登录");
            // 生成临时身份令牌
            String token = HashUtils.md5Digest(form.getAccount() + System.currentTimeMillis());
            redisWrapper.value().set(token, new Operator(user), configuration.getTimeout());

            redisWrapper.addToken(user.getUserId(), token);

            user.setUserAddress(String.valueOf(System.currentTimeMillis()));
            userDao.updateById(user);

            return new LoginVO(user, token);

        }

        throw new RRException("账号和密码不一致");
    }

    public User findUserByTel(String phone){
        return userMapper.findUserByTel(phone);
    }

    public User findUserByName(String user_name){
        return userMapper.findUserByName(user_name);
    }

    public int addUser(User user){
        return userMapper.addUser(user);
    }

    public int modifyUserinfo(User user){
        return userMapper.modifyUserinfo(user);
    }

    public void modifyUserPass(User user){
        userMapper.modifyUserPass(user);
    }

    public void deleteUserinfo(int user_id)  {userMapper.deleteUserinfo(user_id);
    }
    public List<User> findUserByUserId(int user_id){
        return userMapper.findUserByUserId(user_id);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

}
