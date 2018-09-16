package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IDepartmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/depart")
public class DepartmentController extends BaseController {

	@Autowired
	private IDepartmentService departService;
	
	@PostMapping
	@RequiresPermissions("depart_add")
	public Result<String> add(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.insert(depart);
		return new Result<>(flag,flag ? "添加成功！":"添加失败！",0,null);
	}

	@PutMapping
	@RequiresPermissions("depart_update")
	public Result<String> update(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.updateById(depart);
		return new Result<>(flag,flag ? "更新成功！":"更新失败！",0,null);
	}

	@DeleteMapping("/{id}")
	@RequiresPermissions("depart_delete")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = departService.deleteById(id);
		return new Result<>(flag,flag ? "删除成功！":"删除失败！",0,null);
	}

	@GetMapping
	@RequiresPermissions("depart_list")
	public Result<List<SysDepartmentEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = departService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysDepartmentEntity>());
		int sum = departService.selectCount(new EntityWrapper<SysDepartmentEntity>());
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	@RequiresPermissions("depart_list")
	public Result<List<SysDepartmentEntity>> search(
			@ModelAttribute("depart") SysDepartmentEntity depart,
			@ModelAttribute("page") Page page) {
		List<SysDepartmentEntity> list = departService.searchAll(
				depart, page);
		int sum = departService.searchAllCount(depart);
		return new Result<>(true,null,sum,list);
	}

}
