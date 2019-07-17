package com.mall.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/10 10:07
 **/
@Repository
public interface UserDao extends BaseMapper<User> {
    User findUserByTel(String tel);
    User findUserByName(String user_name);
    int addUser(User user);
    int modifyUserinfo(User user);
    void modifyUserPass(User user);
    void deleteUserinfo(int user_id);
    List<User> findUserByUserId(int user_id);
    List<User> selectAll();
}
