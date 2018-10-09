package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IMenuService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private IMenuService menuService;
	
	@PostMapping
	@RequiresPermissions("menu_add")
	public Result<String> add(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.insert(menu);
		Map<String, Object> map = new HashMap<String, Object>();
		return new Result<>(flag,flag?"添加成功！":"添加失败！",0,null);
	}

	@PutMapping
	@RequiresPermissions("menu_update")
	public Result<String> update(@ModelAttribute("menu") SysMenuEntity menu) {
		boolean flag = menuService.updateById(menu);
		return new Result<>(flag,flag?"更新成功！":"更新失败！",0,null);
	}

	@DeleteMapping("/{id}")
	@RequiresPermissions("menu_delete")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = menuService.deleteById(id);
		return new Result<>(flag,flag?"删除成功！":"删除失败！",0,null);
	}

	@GetMapping
	@RequiresPermissions("menu_list")
	public Result<List<SysMenuEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = menuService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysMenuEntity>());
		List<SysMenuEntity> data = list.getRecords();
		data.stream()
			.forEach(s ->{
				if(!"[root]".equals(s.getC_node())){
					SysMenuEntity en = menuService.selectById(s.getC_node());
					s.setC_node(en.getC_menuName());
				}
			});
		return new Result<>(true,null,list.getTotal(),data);
	}

	@GetMapping("/search")
	@RequiresPermissions("menu_list")
	public Result<List<SysMenuEntity>> search(
			@ModelAttribute("menu") SysMenuEntity menu,
			@ModelAttribute("page") Page page) {
		List<SysMenuEntity> list = menuService.searchAll(
				menu, page);
		int sum = menuService.searchAllCount(menu);
		list.stream()
				.forEach(s -> {
					if(!"[root]".equals(s.getC_node())){
						SysMenuEntity en = menuService.selectById(s.getC_node());
						s.setC_node(en.getC_menuName());
					}
				});
		return new Result<>(true,null,sum,list);
	}

	@GetMapping("/export")
	@Transactional(readOnly = true)
	@RequiresPermissions("menu_export")
	public ResponseEntity<byte[]> export() throws Exception {
		List<SysMenuEntity> list = menuService.selectList(new EntityWrapper<>());
		String[] name = {"菜单地址","菜单名称","菜单节点"};
		String[] column = {"c_url","c_menuName","c_node"};
		ExportExcel exportExcel = new ExportExcel("系统菜单数据");
		HSSFWorkbook workbook = exportExcel.wirteExcel(column,name,list);

		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		HttpHeaders headers = getFileHeader("menu.xls");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(outByteStream.toByteArray());
	}
}
