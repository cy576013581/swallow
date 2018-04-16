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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.vo.CommentVo;
import com.cy.example.model.Page;
import com.cy.example.vo.TaskVo;
import com.cy.example.vo.WorkFLowVo;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.entity.workflow.LeaveBillEntity;
import com.cy.example.service.IUserService;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/task")
public class TaskController extends BaseController {
	
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
		List<CommentVo> data = new ArrayList<CommentVo>();
		if(list.size()>0){
			for(Comment task : list){
				SysUserEntity user = userService.selectById(task.getUserId());
				CommentVo ca = new CommentVo();
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
	public Map<String, Object> submit(@ModelAttribute("workflow")WorkFLowVo workflow) {
		workFlowService.compeleteTask(workflow);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "审核成功！");
		return map;
	}

	@GetMapping
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")Page page) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		List<Task> list = workFlowService.findAllTask(String.valueOf(user.getId()));
		List<TaskVo> data = new ArrayList<TaskVo>();
		for(Task task : list){
			TaskVo ca = new TaskVo();
			ca.transfor(task);
			ca.setAssignee(user);
			data.add(ca);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}

	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object> search(
			@ModelAttribute("task") TaskVo task,
			@ModelAttribute("page") Page page) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		List<Task> list = workFlowService.searchAllTask(task, String.valueOf(user.getId()));
		List<TaskVo> data = new ArrayList<TaskVo>();
		for(Task tool : list){
			TaskVo ca = new TaskVo();
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
