package com.cy.example.entity.system;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@TableName("sys_roles")
@SuppressWarnings("serial")
public class SysRoleEntity extends SuperEntity<SysRoleEntity> {

	private String c_roleCode;
	
	private String c_roleName;

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_DEFAULT ) 
	private List<SysPermissionEntity> permisList;// 一个角色对应多个权限

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_DEFAULT ) 
	private List<SysUserEntity> userList;// 一个角色对应多个用户
	
	public String getC_roleName() {
		return c_roleName;
	}

	public void setC_roleName(String c_roleName) {
		this.c_roleName = c_roleName;
	}

	public String getC_roleCode() {
		return c_roleCode;
	}

	public void setC_roleCode(String c_roleCode) {
		this.c_roleCode = c_roleCode;
	}

	public List<SysPermissionEntity> getPermisList() {
		return permisList;
	}

	public void setPermisList(List<SysPermissionEntity> permisList) {
		this.permisList = permisList;
	}

	public List<SysUserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<SysUserEntity> userList) {
		this.userList = userList;
	}



}
