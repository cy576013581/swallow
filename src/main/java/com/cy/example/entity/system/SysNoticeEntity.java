package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_notice")
@SuppressWarnings("serial")
public class SysNoticeEntity extends SuperEntity<SysNoticeEntity> {

	private String c_content;
	
	private String c_title;
	
	private int n_order;

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public int getN_order() {
		return n_order;
	}

	public void setN_order(int n_order) {
		this.n_order = n_order;
	}
}
