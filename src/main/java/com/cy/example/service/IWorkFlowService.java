package com.cy.example.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.vo.DeploymentVo;
import com.cy.example.model.Page;
import com.cy.example.vo.ProcessDefinitionVo;
import com.cy.example.vo.TaskVo;
import com.cy.example.vo.WorkFLowVo;
import com.cy.example.entity.workflow.LeaveBillEntity;

public interface IWorkFlowService {

	

	public List<Deployment> getDeploymentList(Page page);

	public List<Deployment> searchAllDeployment(DeploymentVo deployment, Page page);

	public void deploy(MultipartFile file, String filename);
	
	public void deleteDeploy(String id,boolean cascade);

	public InputStream findImageInputStream(String deploymentId,
			String diagramResourceName);
	
	public List<ProcessDefinition> getProcessDefinitionList(Page page);
	
	public List<ProcessDefinition> searchAllProcessDefinition(ProcessDefinitionVo process, Page page);
	
	public void startProcessDefinition(LeaveBillEntity entity);

	public List<Task> findAllTask(String id);
	
	public List<Task> searchAllTask(TaskVo task, String id);

	public boolean compeleteTask(WorkFLowVo workflow);

	List<String> findOutComeListByTaskId(String taskId);

	LeaveBillEntity findLeaveBillByTaskId(String taskId);

	List<Comment> findCommentByTaskId(String taskId);

	List<Comment> findCommentByLeaveBillId(int id);

	Map<String, Object> findCoordingByTask(String taskId);

	ProcessDefinition findProcessDefinitionByTaskId(String taskId);

}
