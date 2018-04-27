package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysMenuEntity;

public interface IMenuService extends IService<SysMenuEntity>{

	int searchAllCount(SysMenuEntity menu);

	List<SysMenuEntity> searchAll(SysMenuEntity menu,Page page);
	
	List<SysMenuEntity> findRoot();
	
	List<SysMenuEntity> findAll();
	
//	SysMenuEntity findMenuByNode(SysMenuEntity menu);

	List<SysMenuEntity> findUserAll(Long roleId);
}
