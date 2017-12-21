package com.cy.example.carrier;

import org.activiti.engine.task.Task;

import com.cy.example.entity.UserEntity;
import com.cy.example.util.DateUtil;

public class TaskCa {
	
	private String id;
	
	private String name;
	
	private String createTime;
	
	private UserEntity assignee;
	
	public void transfor(Task task){
		this.id = task.getId();
		this.name = task.getName();
		this.createTime = DateUtil.format(task.getCreateTime());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public UserEntity getAssignee() {
		return assignee;
	}

	public void setAssignee(UserEntity assignee) {
		this.assignee = assignee;
	}

	
}
