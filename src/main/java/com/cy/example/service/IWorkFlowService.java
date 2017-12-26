package com.cy.example.service;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.ProcessDefinitionCa;
import com.cy.example.carrier.TaskCa;
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.entity.SuperEntity;

public interface IWorkFlowService {

	

	public List<Deployment> getDeploymentList(PageCa page);

	public List<Deployment> searchAllDeployment(DeploymentCa deployment, PageCa page);

	public void deploy(MultipartFile file, String filename);
	
	public void deleteDeploy(String id,boolean cascade);

	public InputStream findImageInputStream(String deploymentId,
			String diagramResourceName);
	
	public List<ProcessDefinition> getProcessDefinitionList(PageCa page);
	
	public List<ProcessDefinition> searchAllProcessDefinition(ProcessDefinitionCa process, PageCa page);
	
	public void startProcessDefinition(LeaveBillEntity entity);

	public List<Task> findAllTask(String id);
	
	public List<Task> searchAllTask(TaskCa task,String id);

	public boolean compeleteTask(String taskId);

	List<String> findOutComeListByTaskId(String taskId);

	LeaveBillEntity findLeaveBillByTaskId(String taskId);

	List<Comment> findCommentByTaskId(String taskId);

	List<Comment> findCommentByLeaveBillId(int id);

}
