package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping
	public Result<String> add(@ModelAttribute("role") SysRoleEntity role) {
		boolean flag = roleService.insert(role);
		String msg;
		if (flag) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("role") SysRoleEntity role) {
		boolean flag = roleService.updateById(role);
		String msg;
		if (flag) {
			msg = "更新成功！";
		} else {
			msg = "更新失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = roleService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	public Result<List<SysRoleEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = roleService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysRoleEntity>().setSqlSelect("c_roleCode,c_roleName,c_createDate,c_updateDate,id"));
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = roleService.selectCount(new EntityWrapper<SysRoleEntity>());
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	public Result<List<SysRoleEntity>> search(
			@ModelAttribute("role") SysRoleEntity role,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysRoleEntity> list = roleService.searchAll(
				role, page);
		int sum = roleService.searchAllCount(role);
		return new Result<>(true,null,sum,list);
	}

}
