package com.cy.example.carrier;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@TableName("sys_role_menu")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Role_Menu_Ca extends SuperEntity<Role_Menu_Ca>{

	private long n_roleId;

	@TableField(exist = false)
	private String c_roleName;
	
	private long n_menuId;
	
	@TableField(exist = false)
	private String c_menuName;

	@TableField(exist = false)
	private String c_url;

	@TableField(exist = false)
	private String c_node;

	public Role_Menu_Ca(long n_roleId){
		this.n_roleId = n_roleId;
	}
}
