package com.cy.example.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
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
import com.cy.example.carrier.WorkFLowCa;
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
	
	@RequestMapping("/getFlowChart")
	public String getFlowChart(@RequestParam("taskId") String taskId,ModelMap map) throws IOException {
		Map<String, Object> address = workFlowService.findCoordingByTask(taskId);
		ProcessDefinition pd = workFlowService.findProcessDefinitionByTaskId(taskId);
		map.put("address", address);
		map.put("deploymentId", pd.getDeploymentId());
		map.put("diagramResourceName", pd.getDiagramResourceName());
		return "workflow/flowChart";
	}
	
	@RequestMapping("/lookFlowChart")
	public void lookFlowChart(@RequestParam("deploymentId") String deploymentId,
			@RequestParam("diagramResourceName") String diagramResourceName) throws IOException {
		//2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = workFlowService.findImageInputStream(deploymentId,diagramResourceName);
		//3：从response对象获取输出流
		OutputStream out = getResponse().getOutputStream();
		//4：将输入流中的数据读取出来，写到输出流中
		for(int b=-1;(b=in.read())!=-1;){
			out.write(b);
		}
		out.close();
		in.close();
	}
	
	@RequestMapping("/findComment")
	@ResponseBody
	public Map<String, Object> findComment(@RequestParam("id") String id) {
		List<Comment> list = workFlowService.findCommentByTaskId(id);
		List<CommentCa> data = new ArrayList<CommentCa>();
		if(list.size()>0){
			for(Comment task : list){
				UserEntity user = userService.selectById(task.getUserId());
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
	public Map<String, Object> submit(@ModelAttribute("workflow")WorkFLowCa workflow) {
		workFlowService.compeleteTask(workflow);
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
