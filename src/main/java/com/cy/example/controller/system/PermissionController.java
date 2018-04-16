package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/permission")
public class PermissionController extends BaseController {

	@Autowired
	private IPermissionService permissionService;
	
	@PostMapping
	public Result<String> add(@ModelAttribute("per") SysPermissionEntity per) {
		boolean flag = permissionService.insert(per);
		String msg;
		if (flag) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("per") SysPermissionEntity per) {
		boolean flag = permissionService.updateById(per);
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
		boolean flag = permissionService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	public Result<List<SysPermissionEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = permissionService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysPermissionEntity>());
		int sum = permissionService.selectCount(new EntityWrapper<SysPermissionEntity>());
		/*for(SysPermissionEntity entity:data){
			entity.setRoles(new ArrayList<SysRoleEntity>());
		}*/
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	public Result<List<SysPermissionEntity>> search(
			@ModelAttribute("per") SysPermissionEntity per,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysPermissionEntity> list = permissionService.searchAll(
				per, page);
		int sum = permissionService.searchAllCount(per);
		/*for(SysPermissionEntity entity:list){
			entity.setRoles(new ArrayList<SysRoleEntity>());
		}*/
		return new Result<>(true,null,sum,list);
	}

}
