package com.cy.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.example.supplement.redis.RedisClient;

/*
 * 测试redis
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisClient redisClinet;

	@RequestMapping("/set")
	public String set(String key, String value) throws Exception {
		redisClinet.set(key, value);
		return "success";
	}

	@RequestMapping("/get")
	public String get(String key) throws Exception {
		String value = (String) redisClinet.get(key);
		System.out.println(value);
		return value;
	}
}
