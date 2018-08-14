package com.cy.example.vo;

import lombok.Data;
//import org.activiti.engine.repository.ProcessDefinition;

@Data
public class ProcessDefinitionVo {

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

//	public void transfor(ProcessDefinition pro) {
//		this.id = pro.getId();
//		this.name = pro.getName();
//		this.key = pro.getKey();
//		this.version = String.valueOf(pro.getVersion());
//		this.resourceName = pro.getResourceName();
//		this.diagramResourceName = pro.getDiagramResourceName();
//		this.deploymentId = pro.getDeploymentId();
//	}
}
