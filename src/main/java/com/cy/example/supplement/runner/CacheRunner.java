package com.cy.example.supplement.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.service.IUserService;

@Component
@Order(value = 1)
public class CacheRunner implements ApplicationRunner{
	
	@Autowired
	private IUserService userService;
	
	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());

	/*
	 * 在这里进行一些系统重要信息的缓存
	 */
	public void run(ApplicationArguments arg0) throws Exception {
//		new Thread()
//        {
//            public void run()
//            {
//            	System.out.println("=================================CacheRunner===================================");
//            	userCache();
//            }
//        }.start();
		
	}
	
	public void userCache(){
		List<SysUserEntity> list = userService.findAll(null);
		for (SysUserEntity user : list) {
			userService.insertUserCache(user);
		}
		logger.info("[SysUserCache]缓存完成");
	}
}
