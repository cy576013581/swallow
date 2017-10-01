package com.cy.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_roles")
@SuppressWarnings("serial")
public class SysRoleEntity extends SuperEntity<SysRoleEntity> {

	private String c_roleName;

	private List<SysPermisEntity> permisList;// 一个角色对应多个权限

	private List<UserEntity> userList;// 一个角色对应多个用户

	public String getC_roleName() {
		return c_roleName;
	}

	public void setC_roleName(String c_roleName) {
		this.c_roleName = c_roleName;
	}

	public List<SysPermisEntity> getPermisList() {
		return permisList;
	}

	public void setPermisList(List<SysPermisEntity> permisList) {
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
		List<SysPermisEntity> perlist = getPermisList();
		for (SysPermisEntity per : perlist) {
			list.add(per.getC_permisName());
		}
		return list;
	}

	@Override
	public String toString() {
		return "SysRoleEntity [c_roleName=" + c_roleName + ", permisList="
				+ permisList + ", userList=" + userList + "]";
	}

}
