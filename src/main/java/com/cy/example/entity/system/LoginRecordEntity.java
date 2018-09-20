package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName("sys_loginrecord")
@Data
@Accessors(chain = true)
public class LoginRecordEntity extends SuperEntity<LoginRecordEntity> {

	private String c_loginIp;

	private String c_username;

	private String c_province;

	private String c_city;
	
}
