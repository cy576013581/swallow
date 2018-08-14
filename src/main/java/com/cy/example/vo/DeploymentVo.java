package com.cy.example.vo;

import lombok.Data;
//import org.activiti.engine.repository.Deployment;

import com.cy.example.util.DateUtil;

@Data
public class DeploymentVo {
	
	private String id;
	
	private String name;
	
	private String deploymentTime;
	
//	public void transfor(Deployment deploy){
//		this.id = deploy.getId();
//		this.name = deploy.getName();
//		this.deploymentTime = DateUtil.format(deploy.getDeploymentTime());
//	}
}
