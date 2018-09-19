package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_rule")
@Data
public class SysRuleEntity extends SuperEntity<SysRuleEntity>{

	private String c_url;
	
	private String c_permission;
	
	private Integer n_order;
}
