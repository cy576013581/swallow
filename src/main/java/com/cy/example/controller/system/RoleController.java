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
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.carrier.PageCa;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.service.IRoleService;

@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping
	public Map<String, Object> add(@ModelAttribute("role") SysRoleEntity role) {
		boolean flag = roleService.insert(role);
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
	public Map<String, Object> update(@ModelAttribute("role") SysRoleEntity role) {
		boolean flag = roleService.updateById(role);
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
		boolean flag = roleService.deleteById(id);
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
		Page<SysRoleEntity> list = roleService.selectPage(new Page<SysRoleEntity>(page, rows)
				, new EntityWrapper<SysRoleEntity>().setSqlSelect("c_roleCode,c_roleName,c_createDate,c_updateDate,id"));
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = roleService.selectCount(new EntityWrapper<SysRoleEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("role") SysRoleEntity role,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysRoleEntity> list = roleService.searchAll(
				role, page);
		int sum = roleService.searchAllCount(role);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
