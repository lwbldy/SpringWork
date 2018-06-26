package com.lwb.system.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1.LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。主要是AuthorizingRealm类的子类，以及EhCacheManager类。
 2.HashedCredentialsMatcher，这个类是为了对密码进行编码的，防止密码在数据库里明码保存，当然在登陆认证的生活，这个类也负责对form里输入的密码进行编码。
 3.ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm，负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
 4.EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
 5.SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
 6.ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
 7.DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
 8.AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
 */
@Configuration
public class ShiroConfig {
    /**
     * 自定义的Realm
     */
    @Bean(name = "myShiroRealm")
    public UserRealm myShiroRealm(EhCacheManager ehCacheManager){
        UserRealm myShiroRealm = new UserRealm();

        //注入缓存
        myShiroRealm.setCacheManager(ehCacheManager);
        return myShiroRealm;
    }
    @Bean
    public DefaultWebSecurityManager  securityManager(UserRealm realm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();

        securityManager.setCacheManager(getEhCacheManager());
        //设置realm.
        securityManager.setRealm(realm);
        securityManager.setSessionManager(sessionManagerBean());
        return securityManager;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //没有登录默认跳转到的页面
        shiroFilterFactoryBean.setLoginUrl("/nologing");
        //登录成功后跳转到的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");


        //放行，或者限制列表
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/isloging", "authc");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/rowhtml", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * shiro session 配置
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManagerBean(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间（单位毫秒）
        sessionManager.setGlobalSessionTimeout(60000);
        return sessionManager;
    }


    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     * 使用注解@RequiresPermissions时无效。
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }


    /**
     * template 模板使用 shiro 标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     Filter Chain定义说明
     1、一个URL可以配置多个Filter，使用逗号分隔
     2、当设置多个过滤器时，全部验证通过，才视为通过
     3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public EhCacheManager getEhCacheManager(){
        EhCacheManager ehcacheManager = new EhCacheManager();
        ehcacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehcacheManager;
    }



}
