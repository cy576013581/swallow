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
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IUserService;

@Controller
@RequestMapping("/system/loginRecord")
public class LoginRecordController extends BaseController {

	@Autowired
	private ILoginRecordService loginRecordService;

	@Autowired
	private IUserService userService;

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(int page, int rows) {
		Page<LoginRecordEntity> list = loginRecordService.selectPage(new Page<LoginRecordEntity>(page, rows)
				, new EntityWrapper<LoginRecordEntity>());
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = loginRecordService.selectCount(new EntityWrapper<LoginRecordEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("loginRecord") LoginRecordEntity loginRecord,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoginRecordEntity> list = loginRecordService.searchAll(
				loginRecord, page);
		int sum = loginRecordService.searchAllCount(loginRecord, page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
