package com.cy.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("calendars")
@SuppressWarnings("serial")
@Data
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
}
