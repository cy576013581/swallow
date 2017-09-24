package com.cy.example.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cy.example.filter.ShiroPermissionsFilter;
import com.cy.example.filter.ShiroLoginFilter;
import com.cy.example.utils.AuthRealm;
import com.cy.example.utils.CredentialsMatcher;

/*
 * Shiro 配置
 */
@Configuration
public class ShiroConfig {

	private static final Logger logger = LoggerFactory
			.getLogger(ShiroConfig.class);

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();//获取filters  
        //将自定义 的ShiroFilterFactoryBean注入shiroFilter
        filters.put("perms", new ShiroPermissionsFilter());
        
        filters.put("anon", new ShiroLoginFilter());
        // 必须设置SecuritManager  
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/lib/**", "anon");

		filterChainDefinitionMap.put("/index", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		// 这里自定义的权限拦截规则
		filterChainDefinitionMap.put("/system/*/add", "perms[add]");
		filterChainDefinitionMap.put("/system/*/delete", "perms[del]");
		// filterChainDefinitionMap.put("/system/*/list", "perms[list]");
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/system/user/validate");
		// 登录成功后要跳转的链接
		// shiroFilterFactoryBean.setSuccessUrl("/main");

		// 未授权界面;
		// shiroFilterFactoryBean.setUnauthorizedUrl("/menu/403");
		shiroFilterFactoryBean
				.setFilterChainDefinitionMap(filterChainDefinitionMap);

		logger.info("--------------Shiro拦截器工厂类注入成功----------------");
		return shiroFilterFactoryBean;
	}

	/*
	 * 配置自定义的权限登录器
	 */
	@Bean(name = "authRealm")
	public AuthRealm authRealm(
			@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
		AuthRealm authRealm = new AuthRealm();
		authRealm.setCredentialsMatcher(matcher);
		return authRealm;
	}

	/*
	 * 配置核心安全事务管理器
	 */
	@Bean(name = "securityManager")
	public SecurityManager securityManager(
			@Qualifier("authRealm") AuthRealm authRealm) {
		logger.info("--------------shiro安全事务管理器已经加载----------------");
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(authRealm);
		return manager;
	}

	/*
	 * 配置自定义的密码比较器
	 */
	@Bean(name = "credentialsMatcher")
	public CredentialsMatcher credentialsMatcher() {
		return new CredentialsMatcher();
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			@Qualifier("securityManager") SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}
}
