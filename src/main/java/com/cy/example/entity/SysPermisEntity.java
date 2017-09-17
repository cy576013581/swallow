package com.cy.example.entity;

import java.util.List;

public class SysPermisEntity extends BaseEntity{

	private String c_permisName;

    private List<SysRoleEntity> roles;// 一个权限对应一个角色

	public String getC_permisName() {
		return c_permisName;
	}

	public void setC_permisName(String c_permisName) {
		this.c_permisName = c_permisName;
	}

	public List<SysRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleEntity> roles) {
		this.roles = roles;
	}

	
    
}
