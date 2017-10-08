package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysPermissionEntity;
import com.cy.example.mapper.PermissionMapper;
import com.cy.example.service.IPermissionService;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, SysPermissionEntity>
	implements IPermissionService{
	
	@Autowired
	private PermissionMapper permissionMapper;
	

	public List<SysPermissionEntity> searchAll(SysPermissionEntity permission,
			PageCa page) {
		// TODO Auto-generated method stub
		return permissionMapper.searchAll(permission, page);
	}

	public int searchAllCount(SysPermissionEntity permission, PageCa page) {
		// TODO Auto-generated method stub
		return permissionMapper.searchAllCount(permission, page);
	}
}
