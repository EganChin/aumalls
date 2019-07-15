package com.mall.consumer.auth;


import com.mall.common.auth.AuthToken;
import com.mall.common.config.AuthConfig;
import com.mall.common.domain.User;
import com.mall.common.exception.RRException;
import com.mall.common.utils.RedisWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * shiro 数据存储
 *
 * @author LiangYongjie
 * @date 2019-01-06
 */
@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private AuthConfig configuration;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HttpServletRequest request;

    /**
     * token 类型支持
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    /**
     * 授权（验证权限时调用）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		User user = (User) principals.getPrimaryPrincipal();
//		Set<String> roles = new HashSet<>();
//		for (EnumRole value : EnumRole.values()) {
//			if (user.getRoleId() == value.value()) {
//				roles.add(value.toString());
//			}
//		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setRoles(roles);

        return info;
    }

    /**
     * 认证（登录时调用）
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getCredentials();

        /*
         * 管理员在使用时，刷新令牌过期时间
         */
        Object user = redisTemplate.opsForValue().get(accessToken);
        if (user == null) {
            //token过期
            throw new RRException("TOKEN过期", 401);
//            request.getSession().setAttribute("status", 401);
        }

        redisTemplate.expire(accessToken, configuration.getTimeout().getSeconds(), TimeUnit.SECONDS);

        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
