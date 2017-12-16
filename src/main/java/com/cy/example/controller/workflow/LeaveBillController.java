package com.cy.example.controller.workflow;

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
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.service.ILeaveBillService;

@Controller
@RequestMapping("/system/bill")
public class LeaveBillController extends BaseController {

	@Autowired
	private ILeaveBillService billService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("bill") LeaveBillEntity bill) {
		super.add(bill);
		boolean flag = billService.insert(bill);
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
	public Map<String, Object> update(@ModelAttribute("bill") LeaveBillEntity bill) {
		super.update(bill);
		boolean flag = billService.updateById(bill);
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
	public Map<String, Object> delete(@ModelAttribute("bill") LeaveBillEntity bill) {
		boolean flag = billService.deleteById(bill.getId());
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
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<LeaveBillEntity> list = billService.findAll(page);
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = billService.findAllCount();
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("bill") LeaveBillEntity bill,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LeaveBillEntity> list = billService.searchAll(
				bill, page);
		int sum = billService.searchAllCount(bill);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
