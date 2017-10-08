package com.cy.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping("/home")
	public String showHome() {
		return "main/home";
	}

	@RequestMapping("/calendarManage")
	public String calendarManage() {
		return "calendarManage";
	}

	@RequestMapping("/userManage")
	public String userManage() {
		return "userManage";
	}

	@RequestMapping("/loginRecordManage")
	public String loginRecordManage() {
		return "loginRecordManage";
	}

	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return "test_uploadFile";
	}
	
	@RequestMapping("/roleManage")
	public String roleManage() {
		return "roleManage";
	}
	
	@RequestMapping("/permissionManage")
	public String permissionManage() {
		return "permissionManage";
	}

}
