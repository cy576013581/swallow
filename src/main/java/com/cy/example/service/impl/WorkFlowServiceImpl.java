package com.cy.example.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.ProcessDefinitionCa;
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

	
}
