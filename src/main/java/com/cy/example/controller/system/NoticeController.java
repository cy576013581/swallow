package com.cy.example.controller.system;

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
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysNoticeEntity;
import com.cy.example.service.INoticeService;

@Controller
@RequestMapping("/system/notice")
public class NoticeController extends BaseController {

	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("/add")
	@ResponseBody
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

	@RequestMapping("/update")
	@ResponseBody
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

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("role") SysNoticeEntity notice) {
		boolean flag = noticeService.deleteById(notice.getId());
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
	public Map<String, Object> findAll(int page, int rows) {
		Page<SysNoticeEntity> list = noticeService.selectPage(new Page<SysNoticeEntity>(page, rows)
				, new EntityWrapper<SysNoticeEntity>().setSqlSelect("c_title,c_content,n_order,c_createDate,c_updateDate,id"));
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = noticeService.selectCount(new EntityWrapper<SysNoticeEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("role") SysNoticeEntity notice,
			@ModelAttribute("page") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysNoticeEntity> list = noticeService.searchAll(
				notice, page);
		int sum = noticeService.searchAllCount(notice);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
