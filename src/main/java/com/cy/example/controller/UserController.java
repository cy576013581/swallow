package com.cy.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import netscape.javascript.JSObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;
import com.cy.example.domain.User;
import com.cy.example.filter.WebConfig;
import com.cy.example.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;


@Controller
@RequestMapping("/system/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/add")
	@ResponseBody
    public Map<String, Object> addUser(@ModelAttribute("user")User user) {
		user.setC_pwd("123456");
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
    public Map<String, Object> updateUser(@ModelAttribute("user")User user) {
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
    public Map<String, Object> deleteUser(@ModelAttribute("user")User user) {
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
    public String findUser(ModelMap map) {
		User user = userService.findUserById((long)2);
		map.put("user", user);
        return "index";
    }
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Map<String, Object> findAllUser() {
		List<User> list = userService.findUsers();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return map;
    }
	
	@RequestMapping("/searchData")
	@ResponseBody
    public Map<String, Object> searchData(@ModelAttribute("user")User user) {
//		System.out.println(user.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> users  = userService.searchData(user);
		
		map.put("rows", users);
		map.put("total", users.size());
		return map;
    }
	
	
	@RequestMapping("/validate")
	@ResponseBody
    public Map<String, Boolean> validateUser(@ModelAttribute("user")User user,HttpSession session) {
		User getUser = userService.validate(user);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(null==getUser){//登录失败
			map.put("flag",false);
		}else{//登录成功
			map.put("flag",true);
			user.setC_pwd("");
			session.setAttribute(WebConfig.LOGIN_USER, user);
		}
		return map;
    }
	
}
