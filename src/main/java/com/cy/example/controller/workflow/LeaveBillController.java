package com.cy.example.controller.workflow;

import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.entity.workflow.LeaveBillEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.ILeaveBillService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/bill")
public class LeaveBillController extends BaseController {

	@Autowired
	private ILeaveBillService billService;
	
	@PostMapping("/submit")
	public Result<String> submit(@ModelAttribute("bill") LeaveBillEntity bill) {
		WebConfig.add(bill);
		if("未提交".equals(bill.getN_status())){
			bill.setN_status("1");
		}/*else if("审核中".equals(bill.getN_status())){
			bill.setN_status("0");
		}else if("审核通过".equals(bill.getN_status())){
			bill.setN_status("0");
		}*/
		boolean flag = billService.updateMy(bill);
		String msg;
		if (flag) {
			msg = "成功提交审核！";
		} else {
			msg = "提交失败！";
		}
		return new Result<>(flag,msg,0,null);
	}
	
	@PostMapping
	public Result<String> add(@ModelAttribute("bill") LeaveBillEntity bill) {
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		bill.setUser(user);
		boolean flag = billService.insertMy(bill);
		String msg;
		if (flag) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("bill") LeaveBillEntity bill) {
		boolean flag = billService.updateById(bill);
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
		boolean flag = billService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	public Result<List<LeaveBillEntity>> findAll(@ModelAttribute("page")Page page) {
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
		int sum = billService.findAllCount();
		return new Result<>(true,null,sum,list);
	}

	@GetMapping("/search")
	public Result<List<LeaveBillEntity>> search(
			@ModelAttribute("bill") LeaveBillEntity bill,
			@ModelAttribute("page") Page page) {
		List<LeaveBillEntity> list = billService.searchAll(
				bill, page);
		int sum = billService.searchAllCount(bill);
		return new Result<>(true,null,sum,list);
	}

}
