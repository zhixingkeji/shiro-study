package com.example.springbootshiro.realms;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.springbootshiro.model.User;
import com.example.springbootshiro.service.UserService;
import com.example.springbootshiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        得到身份信息
        String principal =  (String) authenticationToken.getPrincipal();

//        获取工厂
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

//        调用方法查找id,获取为user对象
        User user = userService.findByUsername(principal);

        if(ObjectUtils.isNotEmpty(user)){
//            如果不为空 转化为shiro对象
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}
