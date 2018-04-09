package com.cy.example.entity.system;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_user")
@Data
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
