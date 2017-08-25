package com.cy.example.entity;

public class LoginRecordEntity extends BaseEntity{

	private String c_loginIp;
	
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getC_loginIp() {
		return c_loginIp;
	}

	public void setC_loginIp(String c_loginIp) {
		this.c_loginIp = c_loginIp;
	}
	
	
}
