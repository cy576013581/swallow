package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

import java.io.Serializable;

@TableName("sys_menu")
@Data
public class SysMenuEntity extends SuperEntity<SysMenuEntity>
	implements Serializable{

	private String c_url;
	
	private String c_menuName;
	
	private String c_node;
}
