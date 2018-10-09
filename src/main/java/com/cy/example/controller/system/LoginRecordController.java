package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.supplement.poi.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
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
		return new Result<>(true,null,list.getTotal(),list.getRecords());
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

	@GetMapping("/export")
	@Transactional(readOnly = true)
	@RequiresPermissions("loginRecord_export")
	public ResponseEntity<byte[]> export() throws Exception {
		List<LoginRecordEntity> list = loginRecordService.selectList(new EntityWrapper<>());
		String[] name = {"登录用户","登录IP","登陆省份","登陆城市"};
		String[] column = {"c_username","c_loginIp","c_province","c_city"};
		ExportExcel exportExcel = new ExportExcel("登录记录数据");

		HSSFWorkbook workbook = exportExcel.wirteExcel(column,name,list);

		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		HttpHeaders headers = getFileHeader("loginrecord.xls");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(outByteStream.toByteArray());
	}

}
