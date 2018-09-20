package com.cy.example.supplement.aop;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.SuperEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Aspect  
@Component
public class WebControllerAop {

	/*
	execution (* com.xx.xx.impl..*.*(..))
        首先明白这个表达式是用来匹配方法的,各种条件是为了筛选整个项目的方法。
        (类的访问修饰符
        第一个*表示方法返回值类型[*表示所有类型]
        com.xx.xx.impl表示包路径[*表示所有包]
        .[.表示当前包下所有类的方法,..表示当前包下及此包下所有子包中的所有类的方法]
        第二个*表示类名[*表示所有类,可以匹配以X开头或结尾如X*、*X、X*X的类名]
        第三个*表示方法名[*表示所有方法,可以匹配以X开头或结尾的如X*、*X、X*X的方法名]
        (..)表示方法参数[..表示任何参数]
	 */
	
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
		entity.setC_updateDate(DateUtil.getNow(DateUtil.FORMAT_LONG))
			.setN_updater(user.getId());
	}  
	
	@Before("addPointcut()")  
	public void doAddBefore(JoinPoint joinPoint){  
	    //获取目标方法的参数信息  
	    Object[] obj = joinPoint.getArgs();  
	    SuperEntity<?> entity =  (SuperEntity<?>) obj[0];
	    SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
	    entity.setC_createDate(DateUtil.getNow(DateUtil.FORMAT_LONG))
			.setC_updateDate(DateUtil.getNow(DateUtil.FORMAT_LONG))
			.setN_creater(user.getId())
			.setN_updater(user.getId())
			.setN_deleted(0);
	}
}
