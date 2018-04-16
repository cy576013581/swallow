package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.mapper.system.MenuMapper;
import com.cy.example.service.IMenuService;

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

	public List<SysMenuEntity> findRoot() {
		// TODO Auto-generated method stub
		return mapper.findRoot();
	}

	public List<SysMenuEntity> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

}
