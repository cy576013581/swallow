package com.cy.example.carrier;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_user_role")
@Data
public class User_Role_Ca extends SuperEntity<User_Role_Ca>{

	private long n_userId;
	
	@TableField(exist = false)
	private String c_username;
	
	private long n_roleId;

	@TableField(exist = false)
	private String c_roleName;
}
