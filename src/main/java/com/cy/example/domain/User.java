package com.cy.example.domain;

import org.springframework.stereotype.Repository;

@Repository
public class User {

	private long id;
	
	private String c_username;
	
	private String c_pwd;
	
	private String c_phone;
	
	private int n_age;
	
	private int n_sex;

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

	public String getC_pwd() {
		return c_pwd;
	}

	public void setC_pwd(String c_pwd) {
		this.c_pwd = c_pwd;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public int getN_age() {
		return n_age;
	}

	public void setN_age(int n_age) {
		this.n_age = n_age;
	}

	public int getN_sex() {
		return n_sex;
	}

	public void setN_sex(int n_sex) {
		this.n_sex = n_sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", c_username=" + c_username + ", c_pwd="
				+ c_pwd + ", c_phone=" + c_phone + ", n_age=" + n_age
				+ ", n_sex=" + n_sex + "]";
	}
	
}
