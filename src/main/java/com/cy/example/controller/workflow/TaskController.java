package com.cy.example.controller.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.carrier.CommentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.TaskCa;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IUserService;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/task")
public class TaskController extends BaseController {

	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IWorkFlowService workFlowService;
	
	@RequestMapping("/findComment")
	@ResponseBody
	public Map<String, Object> findComment(@RequestParam("id") String id) {
		List<Comment> list = workFlowService.findCommentByTaskId(id);
		List<CommentCa> data = new ArrayList<CommentCa>();
		if(list.size()>0){
			UserEntity user = userService.selectById(id);
			for(Comment task : list){
				CommentCa ca = new CommentCa();
				ca.transfor(task);
				ca.setUser(user);
				data.add(ca);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}
	
	@RequestMapping("/getBillInfo")
	public String getBillInfo(@RequestParam("id") String id,ModelMap map) {
		LeaveBillEntity entity= workFlowService.findLeaveBillByTaskId(id);
		List<String> btnList = workFlowService.findOutComeListByTaskId(id);
		map.put("bill", entity);
		map.put("taskId", id);
		map.put("btnList", btnList);
		return "workflow/leaveBill";
	}
	
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
		List<Task> list = workFlowService.findAllTask(String.valueOf(user.getId()));
		List<TaskCa> data = new ArrayList<TaskCa>();
		for(Task task : list){
			TaskCa ca = new TaskCa();
			ca.transfor(task);
			ca.setAssignee(user);
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
		List<Task> list = workFlowService.searchAllTask(task, String.valueOf(user.getId()));
		List<TaskCa> data = new ArrayList<TaskCa>();
		for(Task tool : list){
			TaskCa ca = new TaskCa();
			ca.transfor(tool);
			ca.setAssignee(user);
			data.add(ca);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}
	
}
