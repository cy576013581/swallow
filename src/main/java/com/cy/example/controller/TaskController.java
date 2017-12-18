package com.cy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.TaskCa;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/task")
public class TaskController extends BaseController {

	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());
	
	@Autowired
	private IWorkFlowService workFlowService;
	
	@RequestMapping("/submit")
	@ResponseBody
	public Map<String, Object> submit(@RequestParam("id") String id) {
		workFlowService.compeleteTask(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "审核成功！");
		return map;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		List<Task> list = workFlowService.findTaskListByName(String.valueOf(user.getId()));
		List<TaskCa> data = new ArrayList<TaskCa>();
		for(Task dep : list){
			TaskCa ca = new TaskCa();
			ca.transfor(dep);
			data.add(ca);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("task") TaskCa task,
			@ModelAttribute("page") PageCa page) {
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		List<Task> list = workFlowService.findTaskListByName(String.valueOf(user.getId()));
		List<TaskCa> data = new ArrayList<TaskCa>();
		for(Task dep : list){
			TaskCa ca = new TaskCa();
			ca.transfor(dep);
			data.add(ca);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}
	
}
