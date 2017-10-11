package com.cy.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.UserEntity;

@Controller
public class IndexController {
	
	@Value("${swallow.system.name}")
	private String SYS_NAME;

	@RequestMapping("/index")
	public String showIndex(ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		return "index";
	}

	@RequestMapping("/main")
	public String showMain(HttpSession session, ModelMap map) {
		UserEntity user = (UserEntity) session
				.getAttribute(WebConfig.LOGIN_USER);
		map.put("user", user);
		map.put("SYS_NAME", SYS_NAME);
		return "main/main";
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		session.removeAttribute(WebConfig.LOGIN_USER);
		return "index";
	}
}
