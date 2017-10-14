package com.cy.example.carrier;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_user_role")
@SuppressWarnings("serial")
public class User_Role_Ca extends SuperEntity<User_Role_Ca>{

	private long n_userId;
	
	@TableField(exist = false)
	private String c_username;
	
	private long n_roleId;

	@TableField(exist = false)
	private String c_roleName;
	

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public String getC_roleName() {
		return c_roleName;
	}

	public void setC_roleName(String c_roleName) {
		this.c_roleName = c_roleName;
	}

	public long getN_userId() {
		return n_userId;
	}

	public void setN_userId(long n_userId) {
		this.n_userId = n_userId;
	}

	public long getN_roleId() {
		return n_roleId;
	}

	public void setN_roleId(long n_roleId) {
		this.n_roleId = n_roleId;
	}
	
	
}
