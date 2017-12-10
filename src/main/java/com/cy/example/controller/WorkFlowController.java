package com.cy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.repository.Deployment;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cy.example.carrier.DeploymentCa;
import com.cy.example.carrier.PageCa;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/workflow")
public class WorkFlowController extends BaseController {

	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());
	
	@Autowired
	private IWorkFlowService workFlowService;
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") String id) {
		workFlowService.deleteDeploy(id, true);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "删除成功！");
		return map;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(@RequestParam("name") String name,  
			MultipartFile file) {
//		workFlowService.deploy(file, name);
//		ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
//		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();  
//	    MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());  
//		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//
//		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
		System.out.println("");
//		List<MultipartFile> files = ((MultipartHttpServletRequest) request)
//				.getFiles("file");
		
//		MultipartFile file = multipartRequest.getFile("file");
//	    workFlowService.deploy(file, name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("msg", "部署成功！");
			
		return "workflow/deployManage";
	}
	
	@RequestMapping("/findAll")
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

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("deployment") Deployment deployment,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Deployment> list = workFlowService.searchAll(
				deployment, page);
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}
	
}
