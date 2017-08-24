package com.cy.example.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.BaseEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.utils.DateUtil;

/**
 * 
 */
public class BaseController{

	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public UserEntity getLoginUserInfo(){
//		System.out.println(getSession().getAttribute(WebConfig.LOGIN_USER).toString());
		return (UserEntity) getSession().getAttribute(WebConfig.LOGIN_USER);
	}

	public HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public void add(BaseEntity entity) {
		entity.setC_createDate(DateUtil.getNow());
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_creater(getLoginUserInfo().getId());
		entity.setN_updater(getLoginUserInfo().getId());
		entity.setN_deleted(0);
    }
	
	public void update(BaseEntity entity) {
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_updater(getLoginUserInfo().getId());
    }

}
