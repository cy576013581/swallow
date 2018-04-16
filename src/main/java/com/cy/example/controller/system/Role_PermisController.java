package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IRole_PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role_permis")
public class Role_PermisController extends BaseController {

	@Autowired
	private IRole_PermisService rpService;
	
	@PostMapping
	public Result<String> add(@ModelAttribute("rp") Role_Permis_Ca rp) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		Map<String, Object> map = new HashMap<String, Object>();
		Role_Permis_Ca user = rpService.selectOne(new EntityWrapper<Role_Permis_Ca>().eq("n_roleId", rp.getN_roleId())
				.eq("n_permisId", rp.getN_permisId()));
		String msg;
		boolean flag;

		if(null == user){
			flag = rpService.insert(rp);
			if (flag) {
				msg = "添加成功！";
			} else {
				msg = "添加失败！";
			}
		}else{
			flag = false;
			msg = "添加失败，该角色已经存在此权限！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("rp") Role_Permis_Ca rp) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		Map<String, Object> map = new HashMap<String, Object>();
		Role_Permis_Ca user = rpService.selectOne(new EntityWrapper<Role_Permis_Ca>().eq("n_roleId", rp.getN_roleId())
				.eq("n_permisId", rp.getN_permisId()));
		String msg;
		boolean flag;

		if(null == user){
			flag = rpService.updateById(rp);
			if (flag) {
				msg = "更新成功！";
			} else {
				msg = "更新失败！";
			}
		}else{
			flag = false;
			msg = "更新失败，该角色已经存在此权限！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = rpService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	public Result<List<Role_Permis_Ca>> findAll(@ModelAttribute("page")Page page) {
		List<Role_Permis_Ca> list = rpService.findAll(page);
		int sum = rpService.findAllCount(page);
		return new Result<>(true,null,sum,list);
	}

	@GetMapping("/search")
	public Result<List<Role_Permis_Ca>> search(
			@ModelAttribute("rp") Role_Permis_Ca rp,
			@ModelAttribute("page") Page page) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		List<Role_Permis_Ca> list = rpService.searchAll(
				rp, page);
		int sum = rpService.searchAllCount(rp);
		return new Result<>(true,null,sum,list);
	}
}
