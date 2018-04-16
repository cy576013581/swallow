package com.cy.example.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.model.Page;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.service.IPermissionService;

@RestController
@RequestMapping("/system/permission")
public class PermissionController extends BaseController {

	@Autowired
	private IPermissionService permissionService;
	
	@PostMapping
	public Map<String, Object> add(@ModelAttribute("per") SysPermissionEntity per) {
		boolean flag = permissionService.insert(per);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "添加成功！");
		} else {
			map.put("flag", flag);
			map.put("msg", "添加失败！");
		}
		return map;
	}

	@PutMapping
	public Map<String, Object> update(@ModelAttribute("per") SysPermissionEntity per) {
		boolean flag = permissionService.updateById(per);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "更新成功！");
		} else {
			map.put("flag", flag);
			map.put("msg", "更新失败！");
		}
		return map;
	}

	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id")Long id) {
		boolean flag = permissionService.deleteById(id);
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

	@GetMapping
	public Map<String, Object> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = permissionService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysPermissionEntity>());
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = permissionService.selectCount(new EntityWrapper<SysPermissionEntity>());
		/*for(SysPermissionEntity entity:data){
			entity.setRoles(new ArrayList<SysRoleEntity>());
		}*/
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("per") SysPermissionEntity per,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysPermissionEntity> list = permissionService.searchAll(
				per, page);
		int sum = permissionService.searchAllCount(per);
		/*for(SysPermissionEntity entity:list){
			entity.setRoles(new ArrayList<SysRoleEntity>());
		}*/
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
