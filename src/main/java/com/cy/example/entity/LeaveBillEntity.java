package com.cy.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("bill_leave")
public class LeaveBillEntity  extends SuperEntity<LeaveBillEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6287349066165478208L;
	
	private String c_leaveReason;
	
	private String c_startTime;
	
	private String c_endTime;
	
	private String c_leaveDays;
	
	private String c_remarks;
	
	private UserEntity user;

	public String getC_leaveReason() {
		return c_leaveReason;
	}

	public void setC_leaveReason(String c_leaveReason) {
		this.c_leaveReason = c_leaveReason;
	}

	public String getC_startTime() {
		return c_startTime;
	}

	public void setC_startTime(String c_startTime) {
		this.c_startTime = c_startTime;
	}

	public String getC_endTime() {
		return c_endTime;
	}

	public void setC_endTime(String c_endTime) {
		this.c_endTime = c_endTime;
	}

	public String getC_leaveDays() {
		return c_leaveDays;
	}

	public void setC_leaveDays(String c_leaveDays) {
		this.c_leaveDays = c_leaveDays;
	}

	public String getC_remarks() {
		return c_remarks;
	}

	public void setC_remarks(String c_remarks) {
		this.c_remarks = c_remarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	

}
