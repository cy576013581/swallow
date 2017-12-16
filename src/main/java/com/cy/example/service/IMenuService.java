package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysMenuEntity;

public interface IMenuService extends IService<SysMenuEntity>{

	int searchAllCount(SysMenuEntity menu);

	List<SysMenuEntity> searchAll(SysMenuEntity menu,PageCa page);
	
	List<SysMenuEntity> findRoot();
	
	List<SysMenuEntity> findAll();
	
//	SysMenuEntity findMenuByNode(SysMenuEntity menu);
}
