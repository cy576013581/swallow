package com.cy.example.controller.system;

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
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.service.IDepartmentService;

@Controller
@RequestMapping("/system/depart")
public class DepartmentController extends BaseController {

	@Autowired
	private IDepartmentService departService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.insert(depart);
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
	public Map<String, Object> update(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.updateById(depart);
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
	public Map<String, Object> delete(@ModelAttribute("depart") SysDepartmentEntity depart) {
		boolean flag = departService.deleteById(depart.getId());
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
		Page<SysDepartmentEntity> list = departService.selectPage(new Page<SysDepartmentEntity>(page, rows)
				, new EntityWrapper<SysDepartmentEntity>());
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = departService.selectCount(new EntityWrapper<SysDepartmentEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("depart") SysDepartmentEntity depart,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysDepartmentEntity> list = departService.searchAll(
				depart, page);
		int sum = departService.searchAllCount(depart);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
