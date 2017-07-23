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
	
	@RequestMapping("/userManage")
    public String userManage() {
		return "userManage";
    }
}
