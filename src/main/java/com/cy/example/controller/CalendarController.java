package com.cy.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.example.entity.CalendarEntity;
import com.cy.example.service.ICalendarService;
import com.cy.example.service.IUserService;

@Controller
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController {

	@Autowired
	private ICalendarService calendarService;

	@Autowired
	private IUserService userService;

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(
			@ModelAttribute("calendar") CalendarEntity calendar) {
		super.add(calendar);
		if (null == calendar.getC_color()) {
			calendar.setC_color("#3a87ad");
		}
		if (null == calendar.getC_title()) {
			calendar.setC_title("默认日程");
		}
		calendar.setC_username(getCurrentUser().getC_username());
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

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("cal") CalendarEntity cal) {
		super.update(cal);
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

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(long id) {
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

	@RequestMapping("/searchAll")
	@ResponseBody
	public Map<String, Object> searchAll(
			@ModelAttribute("cal") CalendarEntity cal, String start, String end) {
		cal.setC_username(getCurrentUser().getC_username());
		List<CalendarEntity> list = calendarService.searchAll(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}
}
