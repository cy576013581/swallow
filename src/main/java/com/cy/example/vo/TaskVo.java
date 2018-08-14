package com.cy.example.vo;

import lombok.Data;
//import org.activiti.engine.task.Task;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Data
public class TaskVo {
	
	private String id;
	
	private String name;
	
	private String createTime;
	
	private SysUserEntity assignee;
	
//	public void transfor(Task task){
//		this.id = task.getId();
//		this.name = task.getName();
//		this.createTime = DateUtil.format(task.getCreateTime());
//	}
}
