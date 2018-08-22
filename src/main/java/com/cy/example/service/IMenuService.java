package com.cy.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.model.Page;

import java.util.List;

public interface IMenuService extends IService<SysMenuEntity>{

	int searchAllCount(SysMenuEntity menu);

	List<SysMenuEntity> searchAll(SysMenuEntity menu,Page page);
	
//	SysMenuEntity findMenuByNode(SysMenuEntity menu);

	List<SysMenuEntity> findRoot();

	List<SysMenuEntity> findAll();

	List<SysMenuEntity> findUserAll(Long roleId);

	List<SysMenuEntity> refreshFindAll();

	List<SysMenuEntity> refreshFindRoot();

	List<SysMenuEntity> refreshUserAll(Long roleId);
}
