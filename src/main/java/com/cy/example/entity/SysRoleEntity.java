package com.cy.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_roles")
@SuppressWarnings("serial")
public class SysRoleEntity extends SuperEntity<SysRoleEntity> {

	private String c_roleCode;
	
	private String c_roleName;

	@TableField(exist = false)
	private List<SysPermissionEntity> permisList;// 一个角色对应多个权限

	@TableField(exist = false)
	private List<UserEntity> userList;// 一个角色对应多个用户
	
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

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public List<String> getPermissionsName() {
		List<String> list = new ArrayList<String>();
		List<SysPermissionEntity> perlist = getPermisList();
		for (SysPermissionEntity per : perlist) {
			list.add(per.getC_permisName());
		}
		return list;
	}



}
