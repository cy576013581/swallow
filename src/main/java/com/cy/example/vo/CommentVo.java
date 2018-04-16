package com.cy.example.vo;

import lombok.Data;
import org.activiti.engine.task.Comment;

import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.util.DateUtil;

@Data
public class CommentVo {

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
