package com.cy.example.carrier;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

public class CommentCa {

	private String id;
	
	private String time;
	
	private String message;
	
	private SysUserEntity user;
	
	public void transfor(Comment comment){
		this.id = comment.getId();
		this.message = comment.getFullMessage();
		this.time = DateUtil.format(comment.getTime());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SysUserEntity getUser() {
		return user;
	}

	public void setUser(SysUserEntity user) {
		this.user = user;
	}
	
	
}
