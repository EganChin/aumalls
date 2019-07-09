package com.mall.consumer.auth;


import com.mall.common.auth.AuthConfig;
import com.mall.common.auth.AuthToken;
import com.mall.common.domain.User;
import com.mall.common.exception.RRException;
import com.mall.common.utils.RedisUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        User user = (User) RedisUtil.value().get(accessToken);
        if (user == null) {
            throw new RRException("token过期", 401);
        } else{
            RedisUtil.t.expire(accessToken, configuration.getTimeout().getSeconds(), TimeUnit.SECONDS);
        }

        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
