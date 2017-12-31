package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_rule")
@SuppressWarnings("serial")
public class SysRuleEntity extends SuperEntity<SysRuleEntity>{

	private String c_url;
	
	private String c_permission;
	
	private int n_order;

	public String getC_url() {
		return c_url;
	}

	public void setC_url(String c_url) {
		this.c_url = c_url;
	}

	public String getC_permission() {
		return c_permission;
	}

	public void setC_permission(String c_permission) {
		this.c_permission = c_permission;
	}

	public int getN_order() {
		return n_order;
	}

	public void setN_order(int n_order) {
		this.n_order = n_order;
	}
	
}
