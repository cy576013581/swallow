package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private IMenuService menuService;
	
	@PostMapping
	public Result<String> add(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.insert(menu);
		Map<String, Object> map = new HashMap<String, Object>();
		return new Result<>(flag,flag?"添加成功！":"添加失败！",0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.updateById(menu);
		return new Result<>(flag,flag?"更新成功！":"更新失败！",0,null);
	}

	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = menuService.deleteById(id);
		return new Result<>(flag,flag?"删除成功！":"删除失败！",0,null);
	}

	@GetMapping
	public Result<List<SysMenuEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = menuService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysMenuEntity>());
		int sum = menuService.selectCount(new EntityWrapper<SysMenuEntity>());
		List<SysMenuEntity> data = list.getRecords();
		for(SysMenuEntity entity : data){
			if(!"[root]".equals(entity.getC_node())){
				SysMenuEntity en = menuService.selectById(entity.getC_node());
				entity.setC_node(en.getC_menuName());
			}
		}
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	public Result<List<SysMenuEntity>> search(
			@ModelAttribute("menu") SysMenuEntity menu,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysMenuEntity> list = menuService.searchAll(
				menu, page);
		for(SysMenuEntity entity : list){
			if(!"[root]".equals(entity.getC_node())){
				SysMenuEntity en = menuService.selectById(entity.getC_node());
				entity.setC_node(en.getC_menuName());
			}
		}
		return new Result<>(true,null,list.size(),list);
	}

}
