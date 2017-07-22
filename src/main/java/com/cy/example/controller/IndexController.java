package com.cy.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.example.filter.WebConfig;

@Controller
public class IndexController {

	@RequestMapping("/index")
    public String showIndex() {
		return "index";
    }
	
	@RequestMapping("/main")
    public String showMain() {
		return "main";
    }
}
