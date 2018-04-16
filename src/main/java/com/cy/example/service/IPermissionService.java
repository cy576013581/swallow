package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysPermissionEntity;

public interface IPermissionService extends IService<SysPermissionEntity> {
	
	List<SysPermissionEntity> searchAll(SysPermissionEntity permission, Page page);

	int searchAllCount(SysPermissionEntity permission);
}
