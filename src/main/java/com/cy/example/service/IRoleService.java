package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysRoleEntity;

public interface IRoleService extends IService<SysRoleEntity> {
	
	List<SysRoleEntity> searchAll(SysRoleEntity sysRole, PageCa page);

	int searchAllCount(SysRoleEntity sysRole, PageCa page);
}
