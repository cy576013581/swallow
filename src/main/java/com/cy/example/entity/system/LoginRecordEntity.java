package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_loginrecord")
@SuppressWarnings("serial")
@Data
public class LoginRecordEntity extends SuperEntity<LoginRecordEntity> {

	private String c_loginIp;

	private String c_username;

	private String c_province;

	private String c_city;
	
}
