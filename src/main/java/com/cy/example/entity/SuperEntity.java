package com.cy.example.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class SuperEntity<T extends Model<?>> extends Model<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected long id;

	protected String c_createDate;

	protected long n_creater;

	protected String c_updateDate;

	protected long n_updater;

	// 是否删除
	@TableLogic
	protected Integer n_deleted;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}