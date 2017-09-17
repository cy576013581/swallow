package com.cy.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.carrier.PageCar;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.LoginRecordService;
import com.cy.example.service.UserService;
import com.cy.example.service.impl.UserServiceImpl;
import com.cy.example.utils.AuthRealm;
import com.cy.example.utils.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginRecordService loginRecordService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/add")
	@ResponseBody
    public Map<String, Object> add(@ModelAttribute("user")UserEntity user) {
		super.add(user);
		int rows = userService.add(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/update")
	@ResponseBody
    public Map<String, Object> update(@ModelAttribute("user")UserEntity user) {
		super.update(user);
    	int rows = userService.update(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/delete")
	@ResponseBody
    public Map<String, Object> delete(@ModelAttribute("user")UserEntity user) {
		int rows = userService.delete(user.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/find")
    public String findOne(ModelMap map) {
		UserEntity user = userService.findUserById((long)2);
		map.put("user", user);
        return "index";
    }
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Map<String, Object> findAll(@ModelAttribute("page")PageCar page) throws JsonProcessingException {
//		System.out.print("================================="+page.toString()+page.getIndex());
		List<UserEntity> list = userService.findAll(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = userService.findAllCount(page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
    }
	
	@RequestMapping("/searchData")
	@ResponseBody
    public Map<String, Object> searchData(@ModelAttribute("user")UserEntity user,@ModelAttribute("pageVo")PageCar page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserEntity> users  = userService.searchAll(user,page);
		int sum = userService.searchAllCount(user, page);
		map.put("rows", users);
		map.put("total", sum);
		return map;
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping("/validate")
	@ResponseBody
    public Map<String, Object> validate(String username,String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
		boolean flag = true;
		String msg = "";
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            UserEntity user=(UserEntity) subject.getPrincipal();
//            getSession().setAttribute(WebConfig.LOGIN_USER, user);
			LoginRecordEntity loginRecord = new LoginRecordEntity();
			loginRecord.setC_createDate(DateUtil.getNow());
			loginRecord.setC_loginIp(super.getIP(getRequest()));
			loginRecord.setC_username(user.getC_username());
			loginRecordService.add(loginRecord);
			msg = "登陆成功！";
			map.put("flag",flag);
        } catch(Exception exception) {
        	if (exception instanceof UnknownAccountException) {
	            logger.info("账号不存在： -- > UnknownAccountException");
	            msg = "登录失败，用户账号不存在！";
	        } else if (exception instanceof IncorrectCredentialsException) {
	        	logger.info(" 密码不正确： -- >IncorrectCredentialsException");
	            msg = "登录失败，用户密码不正确！";
	        } else {
	        	logger.info("else -- >" + exception);
	            msg = "登录失败，发生未知错误："+exception;
	        }
        	map.put("flag",false);
        }finally{
        	map.put("msg",msg);
        	return map;
        }
    }
	
}
