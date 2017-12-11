package com.cy.example.carrier;

import org.activiti.engine.repository.Deployment;

import com.cy.example.util.DateUtil;

public class DeploymentCa {
	
	private String id;
	
	private String name;
	
	private String deploymentTime;
	
	public void transfor(Deployment deploy){
		this.id = deploy.getId();
		this.name = deploy.getName();
		this.deploymentTime = DateUtil.format(deploy.getDeploymentTime());
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

	public String getDeploymentTime() {
		return deploymentTime;
	}

	public void setDeploymentTime(String deploymentTime) {
		this.deploymentTime = deploymentTime;
	}
	
}
