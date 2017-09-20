package com.cy.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	public static String LOGIN_USER = "loginUser";

	public WebConfig() {
		super();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations(
				"classpath:/templates/");

		super.addResourceHandlers(registry);
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截规则：除了login，其他都拦截判断
		// registry.addInterceptor(new
		// LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/system/user/validate");
		super.addInterceptors(registry);
	}

}