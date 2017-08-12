package com.cy.example.domain;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Calendar {
	//主键
	private long id;

	//用户 
	private String c_username;

	//事件
	private String c_title;

	//开始时间 
	private Date d_start;

	//结束时间
	private Date d_end;

	//事件级别 
	private int n_level;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public Date getD_start() {
		return d_start;
	}

	public void setD_start(Date d_start) {
		this.d_start = d_start;
	}

	public Date getD_end() {
		return d_end;
	}

	public void setD_end(Date d_end) {
		this.d_end = d_end;
	}

	public int getN_level() {
		return n_level;
	}

	public void setN_level(int n_level) {
		this.n_level = n_level;
	}

	
	
	
}
