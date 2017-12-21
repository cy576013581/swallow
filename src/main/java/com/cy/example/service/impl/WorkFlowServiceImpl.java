package com.cy.example.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.ProcessDefinitionCa;
import com.cy.example.carrier.TaskCa;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.entity.SuperEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IWorkFlowService;

@Service
public class WorkFlowServiceImpl implements IWorkFlowService{
	/** 运行时Service */  
    @Autowired  
    private RuntimeService runtimeService;  
    /** 任务service */  
    @Autowired  
    private TaskService taskService;  
    @Autowired  
    protected ProcessEngine processEngine;  
    @Autowired  
    protected RepositoryService repositoryService;  
    @Autowired  
    protected HistoryService historyService;  
    @Autowired  
    protected ManagementService managementService;  
    @Autowired  
    protected IdentityService identityService; 
    
    
    /*
     * 部署对象方法区========================================
     *
     */
    
    //删除流程定义
	public void deleteDeploy(String id,boolean cascade) {
		repositoryService.deleteDeployment(id, cascade);
	}
    
    /**部署流程定义*/
	public void deploy(MultipartFile file, String filename) {
		try {
			//2：将File类型的文件转化成ZipInputStream流
			ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
			repositoryService.createDeployment()//创建部署对象
							.name(filename)//添加部署名称
							.addZipInputStream(zipInputStream)//
							.deploy();//完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public List<Deployment> getDeploymentList(PageCa page){
    	List<Deployment> list = repositoryService.createDeploymentQuery()
    					.orderByDeploymenTime().asc()
    					.listPage(page.getIndex(), page.getRows());
    	return list;
    }
    
    public List<Deployment> searchAllDeployment(DeploymentCa deployment, PageCa page) {
		// TODO Auto-generated method stub
		List<Deployment> list = repositoryService.createDeploymentQuery()
				.deploymentNameLike("%" + deployment.getName() + "%")
				.orderByDeploymentName().asc()
				.listPage(page.getIndex(), page.getRows());
		return list;
	}
    
    /*
     * 流程定义方法区========================================
     *
     */
    
    /**查询流程定义的信息，对应表（act_re_procdef）*/
	public List<ProcessDefinition> getProcessDefinitionList(PageCa page) {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()//创建流程定义查询
							.orderByProcessDefinitionVersion().asc()//
							.listPage(page.getIndex(), page.getRows());
		return list;
	}

	public InputStream findImageInputStream(String deploymentId,
			String diagramResourceName) {
		// TODO Auto-generated method stub
		return repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
	}

	public List<ProcessDefinition> searchAllProcessDefinition(
			ProcessDefinitionCa process, PageCa page) {
		// TODO Auto-generated method stub
		List<ProcessDefinition> list =  new ArrayList<ProcessDefinition>();
				
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		if(null != process.getKey() && !"".equals(process.getKey())){
			query.processDefinitionKeyLike("%" + process.getKey() + "%");
		}
		if(null != process.getName() && !"".equals(process.getName())){
			query.processDefinitionNameLike("%" + process.getName() + "%");
		}
		if(null != process.getResourceName() && !"".equals(process.getResourceName())){
			query.processDefinitionResourceNameLike("%" + process.getResourceName() + "%");
		}
		if(null != process.getVersion() && !"".equals(process.getVersion())){
			query.processDefinitionVersion(Integer.valueOf(process.getVersion()));
		}
		
		list = query.orderByProcessDefinitionId().asc()
				.listPage(page.getIndex(), page.getRows());
				
		return list;
	}

	public void startProcessDefinition(LeaveBillEntity entity) {
		// TODO Auto-generated method stub
		//1：使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
		String key  = entity.getClass().getSimpleName().replaceAll("Entity", "");
		
		/**
		 * 2：从Session中获取当前任务的办理人，使用流程变量设置下一个任务的办理人
			    * inputUser是流程变量的名称，
			    * 获取的办理人是流程变量的值
		 */
		Map<String, Object> variables = new HashMap<String,Object>();
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		variables.put("inputUser", user.getId());//表示惟一用户
		/**
		 * 3：	(1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
   				(2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
		 */
		//格式：LeaveBill.id的形式（使用流程变量）
		String objId = key+"."+entity.getId();
		variables.put("objId", objId);
		//4：使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
		runtimeService.startProcessInstanceByKey(key,objId,variables);
	}
	
	/**使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>*/
	public List<Task> findAllTask(String id) {
		List<Task> list = taskService.createTaskQuery()//
					.taskAssignee(String.valueOf(id))//指定个人任务查询
					.orderByTaskCreateTime().asc()//
					.list();
		return list;
	}
	
	/**使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>*/
	public boolean compeleteTask(String taskId) {
		Map<String, Object> variables = new HashMap<String,Object>();
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		variables.put("inputUser", user.getN_superior().getId());//表示上级用户
		taskService.complete(taskId, variables);
		return true;
		
	}

	public List<Task> searchAllTask(TaskCa task, String id) {
		// TODO Auto-generated method stub
		TaskQuery query = taskService.createTaskQuery().taskAssignee(String.valueOf(id));
		if(null != task.getName() && !"".equals(task.getName())){
			query.processDefinitionNameLike("%" + task.getName() + "%");
		}
		List<Task> list = query.orderByTaskCreateTime().asc().list();
		return list;
	}


	
}
