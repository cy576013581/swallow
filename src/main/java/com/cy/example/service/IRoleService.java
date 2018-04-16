package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysRoleEntity;

public interface IRoleService extends IService<SysRoleEntity> {
	
	List<SysRoleEntity> searchAll(SysRoleEntity sysRole, Page page);

	int searchAllCount(SysRoleEntity sysRole);
}
