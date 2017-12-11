package com.cy.example.carrier;

import org.activiti.engine.repository.ProcessDefinition;


public class ProcessDefinitionCa {

	private String id;

	// 流程定义的名称
	private String name;

	// 流程定义的KEY
	private String key;

	// 流程定义的版本
	private String version;

	// 流程定义的规则文件名称
	private String resourceName;

	// 流程定义的规则图片名称
	private String diagramResourceName;

	// 部署ID
	private String deploymentId;

	public void transfor(ProcessDefinition pro) {
		this.id = pro.getId();
		this.name = pro.getName();
		this.key = pro.getKey();
		this.version = String.valueOf(pro.getVersion());
		this.resourceName = pro.getResourceName();
		this.diagramResourceName = pro.getDiagramResourceName();
		this.deploymentId = pro.getDeploymentId();
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDiagramResourceName() {
		return diagramResourceName;
	}

	public void setDiagramResourceName(String diagramResourceName) {
		this.diagramResourceName = diagramResourceName;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	
	
}
