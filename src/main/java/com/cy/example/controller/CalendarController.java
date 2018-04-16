package com.cy.example.controller;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.CalendarEntity;
import com.cy.example.model.Result;
import com.cy.example.service.ICalendarService;
import com.cy.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController {

	@Autowired
	private ICalendarService calendarService;

	@Autowired
	private IUserService userService;

	@PostMapping
	public Result<String> add(
			@ModelAttribute("calendar") CalendarEntity calendar) {
		if (null == calendar.getC_color()) {
			calendar.setC_color("#3a87ad");
		}
		if (null == calendar.getC_title()) {
			calendar.setC_title("默认日程");
		}
		calendar.setC_username(WebConfig.getCurrentUser().getC_username());
		boolean flag = calendarService.insert(calendar);
		String msg;
		if (flag) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("cal") CalendarEntity cal) {
		boolean flag = calendarService.updateMy(cal);
		String msg;
		if (flag) {
			msg = "更新成功！";
		} else {
			msg = "更新失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = calendarService.deleteById(id);
		String msg;
		if (flag) {
			msg = "更新成功！";
		} else {
			msg = "更新失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	public Result<List<CalendarEntity>> findAll(
			@ModelAttribute("cal") CalendarEntity cal, String start, String end) {
		cal.setC_username(WebConfig.getCurrentUser().getC_username());
		List<CalendarEntity> list = calendarService.searchAll(cal);
		return new Result<>(true,null,list.size(),list);
	}
}
