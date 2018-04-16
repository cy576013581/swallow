package com.cy.example.controller.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.example.model.Page;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.entity.workflow.LeaveBillEntity;
import com.cy.example.service.ILeaveBillService;

@RestController
@RequestMapping("/system/bill")
public class LeaveBillController extends BaseController {

	@Autowired
	private ILeaveBillService billService;
	
	@PostMapping("/submit")
	public Map<String, Object> submit(@ModelAttribute("bill") LeaveBillEntity bill) {
		WebConfig.add(bill);
		if("未提交".equals(bill.getN_status())){
			bill.setN_status("1");
		}/*else if("审核中".equals(bill.getN_status())){
			bill.setN_status("0");
		}else if("审核通过".equals(bill.getN_status())){
			bill.setN_status("0");
		}*/
		boolean flag = billService.updateMy(bill);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "成功提交审核！");
		} else {
			map.put("flag", flag);
			map.put("msg", "提交失败！");
		}
		return map;
	}
	
	@PostMapping
	public Map<String, Object> add(@ModelAttribute("bill") LeaveBillEntity bill) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		bill.setUser(user);
		boolean flag = billService.insertMy(bill);
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
	public Map<String, Object> update(@ModelAttribute("bill") LeaveBillEntity bill) {
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

	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id")Long id) {
		boolean flag = billService.deleteById(id);
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
	public Map<String, Object> findAll(@ModelAttribute("page")Page page) {
		List<LeaveBillEntity> list = billService.findAll(page);
		for(LeaveBillEntity bill : list){
			if("0".equals(bill.getN_status())){
				bill.setN_status("未提交");
			}else if("1".equals(bill.getN_status())){
				bill.setN_status("审核中");
			}else if("2".equals(bill.getN_status())){
				bill.setN_status("审核通过");
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = billService.findAllCount();
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("bill") LeaveBillEntity bill,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LeaveBillEntity> list = billService.searchAll(
				bill, page);
		int sum = billService.searchAllCount(bill);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
