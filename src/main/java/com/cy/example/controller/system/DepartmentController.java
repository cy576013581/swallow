package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/depart")
public class DepartmentController extends BaseController {

	@Autowired
	private IDepartmentService departService;
	
	@PostMapping
	public Result<String> add(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.insert(depart);
		String msg;
		if (flag) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.updateById(depart);
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
		boolean flag = departService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	@ApiOperation(value="获取用户列表", notes="获取用户列表的分页列表")
	public Result<List<SysDepartmentEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = departService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysDepartmentEntity>());
		int sum = departService.selectCount(new EntityWrapper<SysDepartmentEntity>());
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	public Result<List<SysDepartmentEntity>> search(
			@ModelAttribute("depart") SysDepartmentEntity depart,
			@ModelAttribute("page") Page page) {
		List<SysDepartmentEntity> list = departService.searchAll(
				depart, page);
		int sum = departService.searchAllCount(depart);
		return new Result<>(true,null,sum,list);
	}

}
