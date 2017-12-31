package com.cy.example.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.service.IRole_PermisService;

@Controller
@RequestMapping("/system/role_permis")
public class Role_PermisController extends BaseController {

	@Autowired
	private IRole_PermisService rpService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("rp") Role_Permis_Ca rp) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		super.add(rp);
		Map<String, Object> map = new HashMap<String, Object>();
		Role_Permis_Ca user = rpService.selectOne(new EntityWrapper<Role_Permis_Ca>().eq("n_roleId", rp.getN_roleId())
				.eq("n_permisId", rp.getN_permisId()));
		if(null == user){
			boolean flag = rpService.insert(rp);
			if (flag) {
				map.put("flag", flag);
				map.put("msg", "添加成功！");
			} else {
				map.put("flag", flag);
				map.put("msg", "添加失败！");
			}
		}else{
			map.put("flag", false);
			map.put("msg", "添加失败，该角色已经存在此权限！");
		}
		
		
		return map;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("rp") Role_Permis_Ca rp) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		super.update(rp);
		Map<String, Object> map = new HashMap<String, Object>();
		Role_Permis_Ca user = rpService.selectOne(new EntityWrapper<Role_Permis_Ca>().eq("n_roleId", rp.getN_roleId())
				.eq("n_permisId", rp.getN_permisId()));
		if(null == user){
			boolean flag = rpService.updateById(rp);
			if (flag) {
				map.put("flag", flag);
				map.put("msg", "更新成功！");
			} else {
				map.put("flag", flag);
				map.put("msg", "更新失败！");
			}
		}else{
			map.put("flag", false);
			map.put("msg", "添加失败，该角色已经存在此权限！");
		}
		return map;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("rp") Role_Permis_Ca rp) {
		boolean flag = rpService.deleteById(rp.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "删除成功！");
		} else {
			map.put("flag", flag);
			map.put("msg", "删除失败！");
		}
		return map;
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<Role_Permis_Ca> list = rpService.findAll(page);
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = rpService.findAllCount(page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("rp") Role_Permis_Ca rp,
			@ModelAttribute("page") PageCa page) {
		rp.setN_roleId(Long.valueOf(" ".equals(rp.getC_roleName()) ? "0" : rp.getC_roleName()));
		rp.setN_permisId(Long.valueOf(" ".equals(rp.getC_permisName()) ? "0" : rp.getC_permisName()));
		Map<String, Object> map = new HashMap<String, Object>();
		List<Role_Permis_Ca> list = rpService.searchAll(
				rp, page);
		int sum = rpService.searchAllCount(rp);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
