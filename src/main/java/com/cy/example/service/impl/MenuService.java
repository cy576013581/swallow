package com.cy.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.mapper.system.MenuMapper;
import com.cy.example.model.Page;
import com.cy.example.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cy.example.config.CacheConfig.CACHE_MENU_ALL;
import static com.cy.example.config.CacheConfig.CACHE_MENU_ROOT;
import static com.cy.example.config.CacheConfig.CACHE_MENU_USER_ALL;

@Service
public class MenuService extends ServiceImpl<MenuMapper, SysMenuEntity>
implements IMenuService{
	
	@Autowired
	private MenuMapper mapper;

	public int searchAllCount(SysMenuEntity menu) {
		// TODO Auto-generated method stub
		return mapper.searchAllCount(menu);
	}

	public List<SysMenuEntity> searchAll(SysMenuEntity menu, Page page) {
		// TODO Auto-generated method stub
		return mapper.searchAll(menu, page);
	}

	@Cacheable(cacheNames = CACHE_MENU_ROOT)
	public List<SysMenuEntity> findRoot() {
		// TODO Auto-generated method stub
		return mapper.findRoot();
	}

	@Cacheable(cacheNames = CACHE_MENU_ALL)
	public List<SysMenuEntity> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Cacheable(cacheNames = CACHE_MENU_USER_ALL,key = "#roleId")
	public List<SysMenuEntity> findUserAll(Long roleId) {
		// TODO Auto-generated method stub
		System.out.println("被调用了一次");
		return mapper.findUserAll(roleId);
	}

	@CachePut(cacheNames = CACHE_MENU_ALL)
	public List<SysMenuEntity> refreshFindAll() {
		return mapper.findAll();
	}

	@CachePut(cacheNames = CACHE_MENU_ROOT)
	public List<SysMenuEntity> refreshFindRoot() {
		return mapper.findRoot();
	}

}
