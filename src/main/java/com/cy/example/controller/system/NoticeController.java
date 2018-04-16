package com.cy.example.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.model.Page;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysNoticeEntity;
import com.cy.example.service.INoticeService;

@RestController
@RequestMapping("/system/notice")
public class NoticeController extends BaseController {

	@Autowired
	private INoticeService noticeService;
	
	@PostMapping
	public Map<String, Object> add(@ModelAttribute("notice") SysNoticeEntity notice) {
		boolean flag = noticeService.insert(notice);
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
	public Map<String, Object> update(@ModelAttribute("role") SysNoticeEntity notice) {
		boolean flag = noticeService.updateById(notice);
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
		boolean flag = noticeService.deleteById(id);
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
	public Map<String, Object> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = noticeService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysNoticeEntity>().setSqlSelect("c_title,c_content,n_order,c_createDate,c_updateDate,id"));
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = noticeService.selectCount(new EntityWrapper<SysNoticeEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@GetMapping("/search")
	public Map<String, Object> search(
			@ModelAttribute("role") SysNoticeEntity notice,
			@ModelAttribute("page") Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysNoticeEntity> list = noticeService.searchAll(
				notice, page);
		int sum = noticeService.searchAllCount(notice);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
