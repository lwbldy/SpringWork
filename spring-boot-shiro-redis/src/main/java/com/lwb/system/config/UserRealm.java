package com.lwb.system.config;

import com.lwb.common.util.ApplicationContextRegister;
import com.lwb.common.util.ShiroUtils;
import com.lwb.system.dao.UserDao;
import com.lwb.system.domain.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = ShiroUtils.getUserId();

        /**
         * 没加缓存，每次访问权限，都会输出，如果加了缓存，就不会每次都查询
         */
        System.out.println("------||------->>"+userId);

        /**
         * 模拟查询数据库，
         */
        Set<String> perms = new HashSet<>();
        perms.add("hasRols");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        String password = new String((char[]) token.getCredentials());

        UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
        // 查询用户信息
        UserDO user = userMapper.list(map).get(0);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        System.out.println("----->>"+password);

        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
