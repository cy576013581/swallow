package com.cy.example.carrier;

import lombok.Data;
import org.activiti.engine.task.Comment;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Data
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
}
