package com.cy.example.carrier;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_role_permission")
@Data
public class Role_Permis_Ca extends SuperEntity<Role_Permis_Ca>{

	private long n_roleId;

	@TableField(exist = false)
	private String c_roleName;
	
	private long n_permisId;
	
	@TableField(exist = false)
	private String c_permisName;
}
