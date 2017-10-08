package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysPermissionEntity;

public interface IPermissionService extends IService<SysPermissionEntity> {
	
	List<SysPermissionEntity> searchAll(SysPermissionEntity permission, PageCa page);

	int searchAllCount(SysPermissionEntity permission, PageCa page);
}
