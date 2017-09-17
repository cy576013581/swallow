package com.cy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cy.example.utils.DateUtil;


@Controller
@RequestMapping("/system/loginRecord")
public class LoginRecordController extends BaseController{
	
	@Autowired
	private LoginRecordService loginRecordService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Map<String, Object> findAll(@ModelAttribute("page")PageCar page) {
		List<LoginRecordEntity> list = loginRecordService.findAll(page);
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = loginRecordService.findAllCount(page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
    }
	
	@RequestMapping("/searchData")
	@ResponseBody
    public Map<String, Object> searchData(@ModelAttribute("loginRecord")LoginRecordEntity loginRecord,@ModelAttribute("page")PageCar page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoginRecordEntity> list  = loginRecordService.searchAll(loginRecord,page);
		int sum = loginRecordService.searchAllCount(loginRecord, page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
    }
	
}
