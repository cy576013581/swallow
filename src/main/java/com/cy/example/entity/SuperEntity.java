package com.cy.example.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

public class SuperEntity<T extends Model> extends Model<T>{

	protected long id;

	protected String c_createDate;

	protected long n_creater;

	protected String c_updateDate;

	protected long n_updater;
	// 是否删除
	protected Integer n_deleted = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getC_createDate() {
		return c_createDate;
	}

	public void setC_createDate(String c_createDate) {
		this.c_createDate = c_createDate;
	}

	public long getN_creater() {
		return n_creater;
	}

	public void setN_creater(long n_creater) {
		this.n_creater = n_creater;
	}

	public String getC_updateDate() {
		return c_updateDate;
	}

	public void setC_updateDate(String c_updateDate) {
		this.c_updateDate = c_updateDate;
	}

	public long getN_updater() {
		return n_updater;
	}

	public void setN_updater(long n_updater) {
		this.n_updater = n_updater;
	}

	public Integer getN_deleted() {
		return n_deleted;
	}

	public void setN_deleted(Integer n_deleted) {
		this.n_deleted = n_deleted;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}