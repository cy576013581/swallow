package com.cy.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("calendars")
@SuppressWarnings("serial")
public class CalendarEntity extends SuperEntity<CalendarEntity> {
	// 用户
	private String c_username;

	// 事件
	private String c_title;

	// 开始时间
	private String c_start;

	// 结束时间
	private String c_end;

	// 背景颜色默认为#3a87ad
	private String c_color;

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

	public String getC_start() {
		return c_start;
	}

	public void setC_start(String c_start) {
		this.c_start = c_start;
	}

	public String getC_end() {
		return c_end;
	}

	public void setC_end(String c_end) {
		this.c_end = c_end;
	}

	public String getC_color() {
		return c_color;
	}

	public void setC_color(String c_color) {
		this.c_color = c_color;
	}

}
