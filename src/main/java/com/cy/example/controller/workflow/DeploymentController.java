package com.cy.example.controller.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.controller.BaseController;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/deploy")
public class DeploymentController extends BaseController {

	@Autowired
	private IWorkFlowService workFlowService;
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id")String id) {
		workFlowService.deleteDeploy(id, true);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "删除成功！");
		return map;
	}
	
	//部署方式后期再做优化
	@PostMapping
	public String add(@RequestParam("name") String name,  
			@RequestParam("file") MultipartFile file) {
		workFlowService.deploy(file, name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "部署成功！");
			
		return "workflow/deployManage";
	}
	
	@GetMapping
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<Deployment> list = workFlowService.getDeploymentList(page);
		List<DeploymentCa> data = new ArrayList<DeploymentCa>();
		for(Deployment dep : list){
			DeploymentCa ca = new DeploymentCa();
			ca.transfor(dep);
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
			@ModelAttribute("deployment") DeploymentCa deployment,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Deployment> list = workFlowService.searchAllDeployment(deployment, page);
		List<DeploymentCa> data = new ArrayList<DeploymentCa>();
		for(Deployment dep : list){
			DeploymentCa ca = new DeploymentCa();
			ca.transfor(dep);
			data.add(ca);
		}
		map.put("rows", data);
		map.put("total", data.size());
		return map;
	}
	
}
