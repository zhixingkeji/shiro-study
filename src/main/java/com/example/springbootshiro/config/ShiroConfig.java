package com.example.springbootshiro.config;


import com.example.springbootshiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

//    负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new HashMap<>();

        //      对所有请求拦截
        map.put("/**", "authc");

        //        放行登录注册页面
        map.put("/login", "anon");
        map.put("/login.jsp", "anon");
        map.put("/register", "anon");
        map.put("/register.jsp", "anon");

//        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        //首页
//        shiroFilterFactoryBean.setSuccessUrl("/index.jsp");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }




//    创建安全管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }



//    创建自定义realm
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        HashedCredentialsMatcher cretedCredentialsMatcher = new HashedCredentialsMatcher();
        cretedCredentialsMatcher.setHashAlgorithmName("MD5");
        cretedCredentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(cretedCredentialsMatcher);

        return customerRealm;
    }
}
