package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_menu")
@SuppressWarnings("serial")
@Data
public class SysMenuEntity extends SuperEntity<SysMenuEntity>{

	private String c_url;
	
	private String c_menuName;
	
	private String c_node;
}
