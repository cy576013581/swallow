package com.cy.example.supplement.aop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSON;
import com.cy.example.config.ShiroConfig;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.SuperEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Aspect  
@Component
public class WebControllerAop {
	
	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());

	@Pointcut("execution(* com.cy.example.controller..*.update(..))")  
    public void updatePointcut(){}  
	
	@Pointcut("execution(* com.cy.example.controller..*.add(..))")  
    public void addPointcut(){}  
	
	/** 
	 * 前置通知，方法调用前被调用 
	 * @param joinPoint 
	 * //AOP代理类的信息  
	    joinPoint.getThis();  
	    //代理的目标对象  
	    joinPoint.getTarget();  
	    //用的最多 通知的签名  
	    Signature signature = joinPoint.getSignature();  
	    //代理的是哪一个方法  
	    System.out.println(signature.getName());  
	    //AOP代理类的名字  
	    System.out.println(signature.getDeclaringTypeName());  
	    //AOP代理类的类（class）信息  
	    signature.getDeclaringType();  
	    //获取RequestAttributes  
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
	    //从获取RequestAttributes中获取HttpServletRequest的信息  
	    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
	    //如果要获取Session信息的话，可以这样写：  
	    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
	    Enumeration<String> enumeration = request.getParameterNames();  
	    Map<String,String> parameterMap = new HashMap<String,String>();
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement();  
	        parameterMap.put(parameter,request.getParameter(parameter));  
	    }  
	    String str = JSON.toJSONString(parameterMap);  
	    if(obj.length > 0) {  
	        System.out.println("请求的参数信息为："+str);  
	    }  
	 */  
	@Before("updatePointcut()")  
	public void doUpdateBefore(JoinPoint joinPoint){  
	    //获取目标方法的参数信息  
	    Object[] obj = joinPoint.getArgs();  
	    SuperEntity<?> entity =  (SuperEntity<?>) obj[0];
	    SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_updater(user.getId());
	}  
	
	@Before("addPointcut()")  
	public void doAddBefore(JoinPoint joinPoint){  
	    //获取目标方法的参数信息  
	    Object[] obj = joinPoint.getArgs();  
	    SuperEntity<?> entity =  (SuperEntity<?>) obj[0];
	    SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
	    entity.setC_createDate(DateUtil.getNow());
		entity.setC_updateDate(DateUtil.getNow());
		entity.setN_creater(user.getId());
		entity.setN_updater(user.getId());
		entity.setN_deleted(0);
	}  
}
