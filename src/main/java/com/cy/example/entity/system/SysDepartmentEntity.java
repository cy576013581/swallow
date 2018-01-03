package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_department")
@SuppressWarnings("serial")
public class SysDepartmentEntity extends SuperEntity<SysDepartmentEntity> {

	private String c_departName;
	
	private String c_departCode;

	public String getC_departName() {
		return c_departName;
	}

	public void setC_departName(String c_departName) {
		this.c_departName = c_departName;
	}

	public String getC_departCode() {
		return c_departCode;
	}

	public void setC_departCode(String c_departCode) {
		this.c_departCode = c_departCode;
	}


}
