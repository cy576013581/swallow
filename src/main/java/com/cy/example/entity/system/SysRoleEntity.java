package com.cy.example.entity.system;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@TableName("sys_role")
@Data
public class SysRoleEntity extends SuperEntity<SysRoleEntity> {

	private String c_roleCode;
	
	private String c_roleName;

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_DEFAULT ) 
	private List<SysPermissionEntity> permisList;// 一个角色对应多个权限

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_DEFAULT ) 
	private List<SysUserEntity> userList;// 一个角色对应多个用户
}
