package com.cy.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;

import com.cy.example.utils.RedisClient;

/*
 * 测试redis
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired  
    private RedisClient redisClinet; 

	@RequestMapping("/set")  
    public String set(String key, String value) throws Exception{  
        redisClinet.set(key, value);  
        return "success";
    }
      
    @RequestMapping("/get")  
    public String get(String key) throws Exception {  
        return redisClinet.get(key);
    }  
}
