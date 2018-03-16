package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("sys_loginrecord")
@SuppressWarnings("serial")
public class LoginRecordEntity extends SuperEntity<LoginRecordEntity> {

	private String c_loginIp;
	
	private String c_username;
	
	private String c_province;
	
	private String c_city;

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public String getC_loginIp() {
		return c_loginIp;
	}

	public void setC_loginIp(String c_loginIp) {
		this.c_loginIp = c_loginIp;
	}

	public String getC_province() {
		return c_province;
	}

	public void setC_province(String c_province) {
		this.c_province = c_province;
	}

	public String getC_city() {
		return c_city;
	}

	public void setC_city(String c_city) {
		this.c_city = c_city;
	}

	@Override
	public String toString() {
		return "LoginRecordEntity [c_loginIp=" + c_loginIp + ", c_username="
				+ c_username + ", c_province=" + c_province + "]";
	}
	
}
