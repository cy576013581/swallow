package com.cy.example.service;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.ProcessDefinitionCa;

public interface IWorkFlowService {

	

	public List<Deployment> getDeploymentList(PageCa page);

	public List<Deployment> searchAllDeployment(DeploymentCa deployment, PageCa page);

	public void deploy(MultipartFile file, String filename);
	
	public void deleteDeploy(String id,boolean cascade);

	public InputStream findImageInputStream(String deploymentId,
			String diagramResourceName);
	
	public List<ProcessDefinition> getProcessDefinitionList(PageCa page);
	
	public List<ProcessDefinition> searchAllProcessDefinition(ProcessDefinitionCa process, PageCa page);

}
