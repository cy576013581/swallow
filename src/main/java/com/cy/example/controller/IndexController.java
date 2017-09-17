package com.cy.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.UserEntity;

@Controller
public class IndexController {

	@RequestMapping("/index")
    public String showIndex() {
		return "index";
    }
	
	@RequestMapping("/main")
    public String showMain(HttpSession session,ModelMap map) {
		UserEntity user = (UserEntity) session.getAttribute(WebConfig.LOGIN_USER);
		map.put("user", user);
		return "main/main";
    }
	
	@RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
		session.removeAttribute(WebConfig.LOGIN_USER);
		return "index";
    }
}
