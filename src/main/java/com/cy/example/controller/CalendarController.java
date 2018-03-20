package com.cy.example.controller;

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

import com.cy.example.config.WebConfig;
import com.cy.example.entity.CalendarEntity;
import com.cy.example.service.ICalendarService;
import com.cy.example.service.IUserService;

@RestController
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController {

	@Autowired
	private ICalendarService calendarService;

	@Autowired
	private IUserService userService;

	@PostMapping
	public Map<String, Object> add(
			@ModelAttribute("calendar") CalendarEntity calendar) {
		if (null == calendar.getC_color()) {
			calendar.setC_color("#3a87ad");
		}
		if (null == calendar.getC_title()) {
			calendar.setC_title("默认日程");
		}
		calendar.setC_username(WebConfig.getCurrentUser().getC_username());
		boolean flag = calendarService.insert(calendar);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", true);
			map.put("msg", "添加成功！");
		} else {
			map.put("flag", false);
			map.put("msg", "添加失败！");
		}
		return map;
	}

	@PutMapping
	public Map<String, Object> update(@ModelAttribute("cal") CalendarEntity cal) {
		int rows = calendarService.updateMy(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		if (rows > 0) {
			map.put("flag", true);
			map.put("msg", "修改成功！");
		} else {
			map.put("flag", false);
			map.put("msg", "修改失败！");
		}
		return map;
	}

	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id")Long id) {
		boolean rows = calendarService.deleteById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (rows) {
			map.put("flag", true);
			map.put("msg", "删除成功！");
		} else {
			map.put("flag", false);
			map.put("msg", "删除失败！");
		}
		return map;
	}

	@GetMapping
	public Map<String, Object> findAll(
			@ModelAttribute("cal") CalendarEntity cal, String start, String end) {
		cal.setC_username(WebConfig.getCurrentUser().getC_username());
		List<CalendarEntity> list = calendarService.searchAll(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}
}
