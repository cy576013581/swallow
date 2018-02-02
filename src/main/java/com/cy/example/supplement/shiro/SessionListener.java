package com.cy.example.supplement.shiro;

import java.util.LinkedHashSet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.StringUtil;

@WebListener
public class SessionListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		if(StringUtil.IsEqual(WebConfig.LOGIN_USER, se.getName())){
			WebConfig.users.add(((SysUserEntity) se.getValue()).getC_username());
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		if(StringUtil.IsEqual(WebConfig.LOGIN_USER, se.getName())){
			WebConfig.users.remove(((SysUserEntity) se.getValue()).getC_username());
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
	}
	
}
