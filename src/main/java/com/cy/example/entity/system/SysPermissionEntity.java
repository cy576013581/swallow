package com.cy.example.entity.system;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@TableName("sys_permission")
@Data
public class SysPermissionEntity extends SuperEntity<SysPermissionEntity> {

	private String c_permisName;
	
	private String c_permisCode;

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private List<SysRoleEntity> roles;// 一个权限对应一个角色
}
