package com.cy.example.entity.system;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("users")
public class SysUserEntity extends SuperEntity<SysUserEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2967710007706812401L;

	private String c_username;

	private String c_pwd;

	private String c_phone;
	
	private String c_email;

	private String n_age;

	private String n_sex;

	private String n_status;
	
	private SysDepartmentEntity n_departmentId;

	@TableField(exist = false)
	private List<SysRoleEntity> roleList;// 一个用户具有多个角色
	
	private SysUserEntity n_superior;

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

	public String getN_age() {
		return n_age;
	}

	public void setN_age(String n_age) {
		this.n_age = n_age;
	}

	public String getN_sex() {
		return n_sex;
	}

	public void setN_sex(String n_sex) {
		this.n_sex = n_sex;
	}

	public String getN_status() {
		return n_status;
	}

	public void setN_status(String n_status) {
		this.n_status = n_status;
	}

	public List<SysRoleEntity> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRoleEntity> roleList) {
		this.roleList = roleList;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public SysUserEntity getN_superior() {
		return n_superior;
	}

	public void setN_superior(SysUserEntity n_superior) {
		this.n_superior = n_superior;
	}

	public SysDepartmentEntity getN_departmentId() {
		return n_departmentId;
	}

	public void setN_departmentId(SysDepartmentEntity n_departmentId) {
		this.n_departmentId = n_departmentId;
	}

	@Override
	public String toString() {
		return "UserEntity [c_username=" + c_username + ", c_pwd=" + c_pwd
				+ ", c_phone=" + c_phone + ", c_email=" + c_email + ", n_age="
				+ n_age + ", n_sex=" + n_sex + ", n_status=" + n_status
				+ ", roleList=" + roleList + "]";
	}

	public String toStringCN() {
		return "注册用户信息： [姓名=" + c_username
				+ ", 联系方式=" + c_phone + ", 邮件=" + c_email + ", 年龄="
				+ n_age + ", 性别=" + n_sex + ", 状态=" + n_status + "]";
	}
	
	
	public byte[] getCredentialsSalt() {
		// TODO Auto-generated method stub
		return this.c_username.getBytes();
	}
}
