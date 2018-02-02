package com.cy.example.config;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;

import com.cy.example.entity.SuperEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Configuration
public class WebConfig{

	public static final String LOGIN_USER = "loginUser";
	
	public static final String CACHE_USER = "CACHE_USER";
	
	public static LinkedHashSet<String> users = new LinkedHashSet<String>();
	
	public static void add(SuperEntity<?> entity) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		entity.setC_createDate(DateUtil.getNow());
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_creater(user.getId());
		entity.setN_updater(user.getId());
		entity.setN_deleted(0);
	}

	public static void update(SuperEntity<?> entity) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_updater(user.getId());
	}

	public static SysUserEntity getCurrentUser() {

		SysUserEntity currentUser = (SysUserEntity) SecurityUtils.getSubject()
				.getSession().getAttribute(WebConfig.LOGIN_USER);
		return currentUser;
	}
	
	public static int getActiveUserSum(){
		return users.size();
	}
	
	public static HashSet<String> getActiveUsers(){
		return users;
	}
}