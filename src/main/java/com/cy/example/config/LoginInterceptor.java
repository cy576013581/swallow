package com.cy.example.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
        //获取session
		HttpSession session = request.getSession(true);
		logger.info("----进入登录拦截器--url："+request.getServletPath()+"-----");
		if(session.getAttribute(WebConfig.LOGIN_USER) == null){
	        logger.info("------跳转到login页面-----");
	        response.sendRedirect(request.getContextPath()+"/index");
	        return false;
	    }else{
	        session.setAttribute(WebConfig.LOGIN_USER, session.getAttribute(WebConfig.LOGIN_USER));
	        return true;
	    }
    }

}

