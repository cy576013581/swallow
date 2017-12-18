package com.cy.example.carrier;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;

import com.cy.example.util.DateUtil;

public class TaskCa {
	
	private String id;
	
	private String name;
	
	private String createTime;
	
	private String assignee;
	
	public void transfor(Task task){
		this.id = task.getId();
		this.name = task.getName();
		this.createTime = DateUtil.format(task.getCreateTime());
		this.assignee = task.getAssignee();
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

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
}
