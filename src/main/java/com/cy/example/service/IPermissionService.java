package com.cy.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.model.Page;

import java.util.List;

public interface IPermissionService extends IService<SysPermissionEntity> {
	
	List<SysPermissionEntity> searchAll(SysPermissionEntity permission, Page page);

	int searchAllCount(SysPermissionEntity permission);

	List<SysPermissionEntity> findAll();
}
