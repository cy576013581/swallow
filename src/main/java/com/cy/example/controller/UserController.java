package com.cy.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.Vo.PageVo;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.LoginRecordService;
import com.cy.example.service.UserService;
import com.cy.example.service.impl.UserServiceImpl;
import com.cy.example.utils.DateUtil;


@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginRecordService loginRecordService;

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
    public Map<String, Object> findAll(@ModelAttribute("pageVo")PageVo page) {
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
    public Map<String, Object> searchData(@ModelAttribute("user")UserEntity user,@ModelAttribute("pageVo")PageVo page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserEntity> users  = userService.searchAll(user,page);
		int sum = userService.searchAllCount(user, page);
		map.put("rows", users);
		map.put("total", sum);
		return map;
    }
	
	
	@RequestMapping("/validate")
	@ResponseBody
    public Map<String, Boolean> validate(@ModelAttribute("user")UserEntity user) {
		UserEntity getUser = userService.validate(user);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(null==getUser){//登录失败
			map.put("flag",false);
		}else{//登录成功
			map.put("flag",true);
			user.setC_pwd("");
			getSession().setAttribute(WebConfig.LOGIN_USER, getUser);
			LoginRecordEntity loginRecord = new LoginRecordEntity();
			loginRecord.setC_createDate(DateUtil.getNow());
			loginRecord.setC_loginIp(super.getIP(getRequest()));
			loginRecord.setN_creater(getUser.getId());
			loginRecordService.add(loginRecord);
		}
		return map;
    }
	
}
