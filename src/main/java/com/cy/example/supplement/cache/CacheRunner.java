package com.cy.example.supplement.cache;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Order(value = 1)
public class CacheRunner implements ApplicationRunner{
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

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
//		menuService.refreshFindAll();
//		menuService.refreshFindRoot();
	}
	
	public void userCache(){
		List<SysUserEntity> list = userService.findAll(null);
		for (SysUserEntity user : list) {
			userService.insertUserCache(user);
		}
		log.info("[SysUserCache]缓存完成");
	}
}
