package com.cy.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import netscape.javascript.JSObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;
import com.cy.example.domain.Calendar;
import com.cy.example.filter.WebConfig;
import com.cy.example.service.impl.CalendarServiceImpl;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;


@Controller
@RequestMapping("/system/calendar")
public class CalendarController {

	@Autowired
	private CalendarServiceImpl calendarService;
	
	
	@RequestMapping("/add")
    public Map<String, Object> addCalendar(@ModelAttribute("calendar")Calendar cal) {
		int rows = calendarService.add(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/update")
    public Map<String, Object> updateCalendar(@ModelAttribute("calendar")Calendar cal) {
		int rows = calendarService.update(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/delete")
    public Map<String, Object> deletecalendar(long id) {
		int rows = calendarService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Map<String, Object> findAllcalendar() {
		List<Calendar> list = calendarService.findCalendars();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return map;
    }
}
