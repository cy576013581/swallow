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
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.service.IMenuService;

@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private IMenuService menuService;
	
	@PostMapping
	public Map<String, Object> add(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.insert(menu);
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
	public Map<String, Object> update(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.updateById(menu);
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
		boolean flag = menuService.deleteById(id);
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
		Page<SysMenuEntity> list = menuService.selectPage(new Page<SysMenuEntity>(page, rows)
				, new EntityWrapper<SysMenuEntity>());
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = menuService.selectCount(new EntityWrapper<SysMenuEntity>());
		List<SysMenuEntity> data = list.getRecords();
		for(SysMenuEntity entity : data){
			if(!"[root]".equals(entity.getC_node())){
				SysMenuEntity en = menuService.selectById(entity.getC_node());
				entity.setC_node(en.getC_menuName());
			}
		}
		map.put("rows", data);
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("menu") SysMenuEntity menu,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysMenuEntity> list = menuService.searchAll(
				menu, page);
		for(SysMenuEntity entity : list){
			if(!"[root]".equals(entity.getC_node())){
				SysMenuEntity en = menuService.selectById(entity.getC_node());
				entity.setC_node(en.getC_menuName());
			}
		}
		int sum = menuService.searchAllCount(menu);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
