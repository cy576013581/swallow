package com.cy.example.carrier;

import java.util.Date;

import org.activiti.engine.repository.Deployment;

public class DeploymentCa {
	
	private String id;
	
	private String name;
	
	private Date deploymentTime;
	
	public void transfor(Deployment deploy){
		DeploymentCa ca = new DeploymentCa();
		this.id = deploy.getId();
		this.name = deploy.getName();
		this.deploymentTime = deploy.getDeploymentTime();
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

	public Date getDeploymentTime() {
		return deploymentTime;
	}

	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}
	
}
