package com.cy.example.controller.workflow;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import com.cy.example.model.Result;
//import org.activiti.engine.repository.Deployment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;

//import com.cy.example.vo.DeploymentVo;
//import com.cy.example.model.Page;
import com.cy.example.controller.BaseController;
//import com.cy.example.service.IWorkFlowService;

@Controller
@RequestMapping("/system/deploy")
public class DeploymentController extends BaseController {

//	@Autowired
//	private IWorkFlowService workFlowService;
//
//	@DeleteMapping("/{id}")
//	@ResponseBody
//	public Result<String> delete(@PathVariable("id")String id) {
//		workFlowService.deleteDeploy(id, true);
//		return new Result<>(true,"删除成功！",0,null);
//	}
//
//	//部署方式后期再做优化
//	@PostMapping
//	public String add(@RequestParam("name") String name,
//			@RequestParam("file") MultipartFile file) {
//		workFlowService.deploy(file, name);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("flag", true);
//		map.put("msg", "部署成功！");
//
//		return "workflow/deployManage";
//	}
//
//	@GetMapping
//	@ResponseBody
//	public Result<List<DeploymentVo>> findAll(@ModelAttribute("page")Page page) {
//		List<Deployment> list = workFlowService.getDeploymentList(page);
//		List<DeploymentVo> data = new ArrayList<DeploymentVo>();
////		for(Deployment dep : list){
////			DeploymentVo ca = new DeploymentVo();
////			ca.transfor(dep);
////			data.add(ca);
////		}
//		data = list.stream().map(dep -> {
//			DeploymentVo ca = new DeploymentVo();
//			ca.transfor(dep);
//			return ca;
//		}).collect(Collectors.toList());
//
//		return new Result<>(true,null,data.size(),data);
//	}
//
//	@GetMapping("/search")
//	@ResponseBody
//	public Result<List<DeploymentVo>> search(
//			@ModelAttribute("deployment") DeploymentVo deployment,
//			@ModelAttribute("page") Page page) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<Deployment> list = workFlowService.searchAllDeployment(deployment, page);
//		List<DeploymentVo> data = new ArrayList<DeploymentVo>();
////		for(Deployment dep : list){
////			DeploymentVo ca = new DeploymentVo();
////			ca.transfor(dep);
////			data.add(ca);
////		}
//		data = list.stream().map(dep -> {
//			DeploymentVo ca = new DeploymentVo();
//			ca.transfor(dep);
//			return ca;
//		}).collect(Collectors.toList());
//		return new Result<>(true,null,data.size(),data);
//	}
	
}
