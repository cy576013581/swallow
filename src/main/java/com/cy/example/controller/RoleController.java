package com.cy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysPermisEntity;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IRoleService;

@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("role") SysRoleEntity role) {
		super.add(role);
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

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("role") SysRoleEntity role) {
		super.update(role);
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

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("role") SysRoleEntity role) {
		boolean flag = roleService.deleteById(role.getId());
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
	public Map<String, Object> findAll(int page, int rows) {
		Page<SysRoleEntity> list = roleService.selectPage(new Page<SysRoleEntity>(page, rows)
				, new EntityWrapper<SysRoleEntity>());
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = roleService.selectCount(new EntityWrapper<SysRoleEntity>());
		List<SysRoleEntity> data = list.getRecords();
		for(SysRoleEntity entity:data){
			entity.setPermisList(new ArrayList<SysPermisEntity>());
			entity.setUserList(new ArrayList<UserEntity>());
		}
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("loginRecord") SysRoleEntity role,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysRoleEntity> list = roleService.searchAll(
				role, page);
		int sum = roleService.searchAllCount(role, page);
		for(SysRoleEntity entity:list){
			entity.setPermisList(new ArrayList<SysPermisEntity>());
			entity.setUserList(new ArrayList<UserEntity>());
		}
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
