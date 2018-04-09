package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_department")
@SuppressWarnings("serial")
@Data
public class SysDepartmentEntity extends SuperEntity<SysDepartmentEntity> {

	private String c_departName;
	
	private String c_departCode;
}
