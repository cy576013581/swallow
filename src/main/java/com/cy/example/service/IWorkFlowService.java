package com.cy.example.service;

import java.io.File;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.PageCa;

public interface IWorkFlowService {

	public List<ProcessDefinition> getProcessDefinitionList(PageCa page);

	public List<Deployment> getDeploymentList(PageCa page);

	public List<Deployment> searchAll(Deployment deployment, PageCa page);

	public void deploy(MultipartFile file, String filename);

}
