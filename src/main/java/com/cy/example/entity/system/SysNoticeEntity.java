package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("sys_notice")
@Data
public class SysNoticeEntity extends SuperEntity<SysNoticeEntity> {

	private String c_content;
	
	private String c_title;
	
	private Integer n_order;
}
