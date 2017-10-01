package com.cy.example.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_permission")
@SuppressWarnings("serial")
public class SysPermisEntity extends SuperEntity<SysPermisEntity> {

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

	@Override
	public String toString() {
		return "SysPermisEntity [c_permisName=" + c_permisName + ", roles="
				+ roles + "]";
	}

}
