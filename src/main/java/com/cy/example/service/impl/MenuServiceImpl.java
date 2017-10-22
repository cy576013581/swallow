package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysMenuEntity;
import com.cy.example.mapper.MenuMapper;
import com.cy.example.service.IMenuService;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenuEntity>
implements IMenuService{
	
	@Autowired
	private MenuMapper mapper;

	public int searchAllCount(SysMenuEntity menu, PageCa page) {
		// TODO Auto-generated method stub
		return mapper.searchAllCount(menu, page);
	}

	public List<SysMenuEntity> searchAll(SysMenuEntity menu, PageCa page) {
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
