package com.cy.example.controller;

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
import com.cy.example.entity.SysMenuEntity;
import com.cy.example.service.IMenuService;

@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("menu") SysMenuEntity menu) {
		super.add(menu);
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

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("menu") SysMenuEntity menu) {
		super.update(menu);
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

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.deleteById(menu.getId());
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

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
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
