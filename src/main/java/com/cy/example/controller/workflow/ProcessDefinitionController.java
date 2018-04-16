package com.cy.example.controller.workflow;

import com.cy.example.controller.BaseController;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IWorkFlowService;
import com.cy.example.vo.ProcessDefinitionVo;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Result<List<ProcessDefinitionVo>> findAll(@ModelAttribute("page")Page page) {
		List<ProcessDefinition> list = workFlowService.getProcessDefinitionList(page);
		List<ProcessDefinitionVo> data = new ArrayList<ProcessDefinitionVo>();
		for (ProcessDefinition pro : list) {
			ProcessDefinitionVo pa = new ProcessDefinitionVo();
			pa.transfor(pro);
			data.add(pa);
		}
		return new Result<>(true, null, data.size(), data);
	}

	@GetMapping("/search")
	public Result<List<ProcessDefinitionVo>> search(
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
		return new Result<>(true, null, data.size(), data);
	}
}
