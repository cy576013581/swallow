package com.cy.example.controller.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.carrier.PageCa;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.entity.workflow.LeaveBillEntity;
import com.cy.example.service.ILeaveBillService;

@Controller
@RequestMapping("/system/bill")
public class LeaveBillController extends BaseController {

	@Autowired
	private ILeaveBillService billService;
	
	@RequestMapping("/submit")
	@ResponseBody
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
	
	@RequestMapping("/add")
	@ResponseBody
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

	@RequestMapping("/update")
	@ResponseBody
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
