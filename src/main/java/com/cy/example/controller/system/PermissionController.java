package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IPermissionService;
import com.cy.example.supplement.poi.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/system/permission")
public class PermissionController extends BaseController {

	@Autowired
	private IPermissionService permissionService;
	
	@PostMapping
    @RequiresPermissions("permission_add")
	public Result<String> add(@ModelAttribute("per") SysPermissionEntity per) {
		SysPermissionEntity getPer = permissionService.selectOne(new EntityWrapper<SysPermissionEntity>()
				.eq("c_permisCode",per.getC_permisCode()));
		boolean flag = false;
		String msg;
		if (getPer != null){
			msg = "添加失败，权限已存在！";
		}else{
			flag = permissionService.insert(per);
			if (flag) {
				msg = "添加成功！";
			} else {
				msg = "添加失败！";
			}
		}

		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
    @RequiresPermissions("permission_update")
	public Result<String> update(@ModelAttribute("per") SysPermissionEntity per) {
		boolean flag = permissionService.updateById(per);
		return new Result<>(flag,flag?"更新成功！":"更新失败！",0,null);
	}

	@DeleteMapping("/{id}")
    @RequiresPermissions("permission_delete")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = permissionService.deleteById(id);
		return new Result<>(flag,flag?"删除成功！":"删除失败！",0,null);
	}

	@GetMapping
    @RequiresPermissions("permission_list")
	public Result<List<SysPermissionEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = permissionService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysPermissionEntity>());
		return new Result<>(true,null,list.getTotal(),list.getRecords());
	}

	@GetMapping("/search")
    @RequiresPermissions("permission_list")
	public Result<List<SysPermissionEntity>> search(
			@ModelAttribute("per") SysPermissionEntity per,
			@ModelAttribute("page") Page page) {
		List<SysPermissionEntity> list = permissionService.searchAll(
				per, page);
		int sum = permissionService.searchAllCount(per);
		return new Result<>(true,null,sum,list);
	}

	@GetMapping("/export")
	@Transactional(readOnly = true)
	@RequiresPermissions("permission_export")
	public ResponseEntity<byte[]> export() throws Exception {
		List<SysPermissionEntity> list = permissionService.selectList(new EntityWrapper<>());
		String[] name = {"ID","权限代码","权限名称","创建时间","更新时间"};
		String[] column = {"id","c_permisCode","c_permisName","c_createDate","c_updateDate"};
		ExportExcel exportExcel = new ExportExcel("系统权限数据");
		HSSFWorkbook workbook = exportExcel.wirteExcel(column,name,list);
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		HttpHeaders headers = getFileHeader("permission.xls");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(outByteStream.toByteArray());
	}
}
