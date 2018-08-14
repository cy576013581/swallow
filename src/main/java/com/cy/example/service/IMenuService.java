package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysMenuEntity;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import static com.cy.example.config.CacheConfig.CACHE_MENU_ALL;
import static com.cy.example.config.CacheConfig.CACHE_MENU_ROOT;
import static com.cy.example.config.CacheConfig.CACHE_MENU_USER_ALL;

public interface IMenuService extends IService<SysMenuEntity>{

	int searchAllCount(SysMenuEntity menu);

	List<SysMenuEntity> searchAll(SysMenuEntity menu,Page page);
	
//	SysMenuEntity findMenuByNode(SysMenuEntity menu);

//	@Cacheable(cacheNames = CACHE_MENU_ROOT)
	List<SysMenuEntity> findRoot();

//	@Cacheable(cacheNames = CACHE_MENU_ALL)
	List<SysMenuEntity> findAll();

//	@Cacheable(cacheNames = CACHE_MENU_USER_ALL,key = "#roleId")
	List<SysMenuEntity> findUserAll(Long roleId);

//	@CachePut(cacheNames = CACHE_MENU_ALL)
	List<SysMenuEntity> refreshFindAll();

//	@CachePut(cacheNames = CACHE_MENU_ROOT)
	List<SysMenuEntity> refreshFindRoot();
}
