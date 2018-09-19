package com.cy.example.entity.workflow;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import com.cy.example.entity.system.SysUserEntity;

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
	
	private SysUserEntity user;
	
	//0：未提交   1：审核中    2：审核通过
	private String n_status;
	
	public LeaveBillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveBillEntity(String n_status,String c_updateDate) {
		super();
		this.n_status = n_status;
		this.c_updateDate = c_updateDate;
	}

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

	public SysUserEntity getUser() {
		return user;
	}

	public void setUser(SysUserEntity user) {
		this.user = user;
	}

	public String getN_status() {
		//0：未提交   1：审核中    2：审核通过
		/*if("0".equals(n_status)){
			return "未提交";
		}else if("1".equals(n_status)){
			return "审核中";
		}else if("2".equals(n_status)){
			return "审核通过";
		}else{
			return n_status;
		}*/
		return n_status;
	}

	public void setN_status(String n_status) {
		/*if("未提交".equals(n_status)){
			this.n_status = "0";
		}else if("审核中".equals(n_status)){
			this.n_status = "1";
		}else if("审核通过".equals(n_status)){
			this.n_status = "2";
		}else{
			this.n_status = n_status;
		}*/
		this.n_status = n_status;
	}

}
