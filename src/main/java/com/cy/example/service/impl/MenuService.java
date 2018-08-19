package com.cy.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.mapper.system.MenuMapper;
import com.cy.example.model.Page;
import com.cy.example.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cy.example.config.CacheConfig.*;

@Slf4j
@Service
public class MenuService extends ServiceImpl<MenuMapper, SysMenuEntity>
implements IMenuService{
	
	@Autowired
	private MenuMapper mapper;

//	@CacheEvict(cacheNames = {CACHE_MENU_ROOT,CACHE_MENU_ALL,CACHE_MENU_USER_ALL})
//	public boolean insert(SysMenuEntity menu){
//		return super.insert(menu);
//	}

	public int searchAllCount(SysMenuEntity menu) {
		// TODO Auto-generated method stub
		return mapper.searchAllCount(menu);
	}

	public List<SysMenuEntity> searchAll(SysMenuEntity menu, Page page) {
		// TODO Auto-generated method stub
		return mapper.searchAll(menu, page);
	}

	@Cacheable(value = CACHE_MENU_ROOT)
	public List<SysMenuEntity> findRoot() {
		// TODO Auto-generated method stub
		return mapper.findRoot();
	}

	@Cacheable(value = CACHE_MENU_ALL)
	public List<SysMenuEntity> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Cacheable(value = CACHE_MENU_USER_ALL,key = "#roleId")
	public List<SysMenuEntity> findUserAll(Long roleId) {
		// TODO Auto-generated method stub
		log.info("Called once...");
		return mapper.findUserAll(roleId);
	}

	@CachePut(value = CACHE_MENU_ALL)
	public List<SysMenuEntity> refreshFindAll() {
		return mapper.findAll();
	}

	@CachePut(value = CACHE_MENU_ROOT)
	public List<SysMenuEntity> refreshFindRoot() {
		return mapper.findRoot();
	}

	@CachePut(value = {CACHE_MENU_USER_ALL},key = "#roleId")
	public List<SysMenuEntity> refreshUserAll(Long roleId) {
		log.info("refreshUserAll...");
		return mapper.findUserAll(roleId);
	}
}
