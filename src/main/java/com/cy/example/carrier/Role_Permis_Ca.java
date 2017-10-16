package com.cy.example.carrier;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_role_permission")
@SuppressWarnings("serial")
public class Role_Permis_Ca extends SuperEntity<Role_Permis_Ca>{

	private long n_roleId;

	@TableField(exist = false)
	private String c_roleName;
	
	private long n_permisId;
	
	@TableField(exist = false)
	private String c_permisName;

	public long getN_roleId() {
		return n_roleId;
	}

	public void setN_roleId(long n_roleId) {
		this.n_roleId = n_roleId;
	}

	public String getC_roleName() {
		return c_roleName;
	}

	public void setC_roleName(String c_roleName) {
		this.c_roleName = c_roleName;
	}

	public long getN_permisId() {
		return n_permisId;
	}

	public void setN_permisId(long n_permisId) {
		this.n_permisId = n_permisId;
	}

	public String getC_permisName() {
		return c_permisName;
	}

	public void setC_permisName(String c_permisName) {
		this.c_permisName = c_permisName;
	}
	

	
	
}
