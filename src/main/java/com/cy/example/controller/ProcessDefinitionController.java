package com.cy.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
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
import com.cy.example.carrier.ProcessDefinitionCa;
import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/process")
public class ProcessDefinitionController extends BaseController {

	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());
	
	@Autowired
	private IWorkFlowService workFlowService;
	
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
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<ProcessDefinition> list = workFlowService.getProcessDefinitionList(page);
		List<ProcessDefinitionCa> data = new ArrayList<ProcessDefinitionCa>();
		for(ProcessDefinition pro : list){
			ProcessDefinitionCa pa = new ProcessDefinitionCa();
			pa.transfor(pro);
			data.add(pa);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("process") ProcessDefinitionCa process,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProcessDefinition> list = workFlowService.searchAllProcessDefinition(process, page);
		List<ProcessDefinitionCa> data = new ArrayList<ProcessDefinitionCa>();
		for(ProcessDefinition pro : list){
			ProcessDefinitionCa pa = new ProcessDefinitionCa();
			pa.transfor(pro);
			data.add(pa);
		}
		map.put("rows", data);
		map.put("total", data.size());
		return map;
	}
	
}
