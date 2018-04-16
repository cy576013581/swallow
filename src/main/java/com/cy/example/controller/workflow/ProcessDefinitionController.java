package com.cy.example.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.example.model.Page;
import com.cy.example.vo.ProcessDefinitionVo;
import com.cy.example.controller.BaseController;
import com.cy.example.service.IWorkFlowService;

@RestController
@RequestMapping("/system/process")
public class ProcessDefinitionController extends BaseController {

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
	
	@GetMapping
	public Map<String, Object> findAll(@ModelAttribute("page")Page page) {
		List<ProcessDefinition> list = workFlowService.getProcessDefinitionList(page);
		List<ProcessDefinitionVo> data = new ArrayList<ProcessDefinitionVo>();
		for(ProcessDefinition pro : list){
			ProcessDefinitionVo pa = new ProcessDefinitionVo();
			pa.transfor(pro);
			data.add(pa);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", data);
		map.put("total", data.size());
		
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("process") ProcessDefinitionVo process,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProcessDefinition> list = workFlowService.searchAllProcessDefinition(process, page);
		List<ProcessDefinitionVo> data = new ArrayList<ProcessDefinitionVo>();
		for(ProcessDefinition pro : list){
			ProcessDefinitionVo pa = new ProcessDefinitionVo();
			pa.transfor(pro);
			data.add(pa);
		}
		map.put("rows", data);
		map.put("total", data.size());
		return map;
	}
	
}
