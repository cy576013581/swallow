package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.ILoginRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/loginRecord")
public class LoginRecordController extends BaseController {

	@Autowired
	private ILoginRecordService loginRecordService;

	@GetMapping
	@RequiresPermissions("loginRecord_list")
	public Result<List<LoginRecordEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = loginRecordService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<LoginRecordEntity>().orderBy("c_createDate",false));
		int sum = loginRecordService.selectCount(new EntityWrapper<LoginRecordEntity>());
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	@RequiresPermissions("loginRecord_list")
	public Result<List<LoginRecordEntity>> search(
			@ModelAttribute("loginRecord") LoginRecordEntity loginRecord,
			@ModelAttribute("page") Page page) {
		List<LoginRecordEntity> list = loginRecordService.searchAll(
				loginRecord, page);
		int sum = loginRecordService.searchAllCount(loginRecord);
		return new Result<>(true,null,sum,list);
	}

}
