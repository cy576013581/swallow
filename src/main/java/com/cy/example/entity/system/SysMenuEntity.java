package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_menu")
@SuppressWarnings("serial")
public class SysMenuEntity extends SuperEntity<SysMenuEntity>{

	private String c_url;
	
	private String c_menuName;
	
	private String c_node;

	public String getC_url() {
		return c_url;
	}

	public void setC_url(String c_url) {
		this.c_url = c_url;
	}

	public String getC_menuName() {
		return c_menuName;
	}

	public void setC_menuName(String c_menuName) {
		this.c_menuName = c_menuName;
	}

	public String getC_node() {
		return c_node;
	}

	public void setC_node(String c_node) {
		this.c_node = c_node;
	}
}
