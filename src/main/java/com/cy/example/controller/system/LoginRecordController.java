package com.cy.example.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.model.Page;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IUserService;

@RestController
@RequestMapping("/system/loginRecord")
public class LoginRecordController extends BaseController {

	@Autowired
	private ILoginRecordService loginRecordService;

	@Autowired
	private IUserService userService;

	@GetMapping
	public Map<String, Object> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = loginRecordService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<LoginRecordEntity>().orderBy("c_createDate",false));
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = loginRecordService.selectCount(new EntityWrapper<LoginRecordEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("loginRecord") LoginRecordEntity loginRecord,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoginRecordEntity> list = loginRecordService.searchAll(
				loginRecord, page);
		int sum = loginRecordService.searchAllCount(loginRecord);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
