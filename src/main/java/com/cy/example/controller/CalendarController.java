package com.cy.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import netscape.javascript.JSObject;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.CalendarEntity;
import com.cy.example.service.CalendarService;
import com.cy.example.service.UserService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;


@Controller
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController{

	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/add")
	@ResponseBody
    public Map<String, Object> add(@ModelAttribute("calendar")CalendarEntity calendar) {
		super.add(calendar);
		if(null == calendar.getC_color()){
			calendar.setC_color("#3a87ad");
		}
		if(null == calendar.getC_title()){
			calendar.setC_title("默认日程");
		}
		calendar.setC_username(getCurrentUser().getC_username());
		int rows = calendarService.add(calendar);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/update")
	@ResponseBody
    public Map<String, Object> update(@ModelAttribute("cal")CalendarEntity cal) {
		super.update(cal);
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
	@ResponseBody
    public Map<String, Object> delete(long id) {
		int rows = calendarService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(rows>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
    }
	
	@RequestMapping("/searchAll")
	@ResponseBody
    public Map<String, Object> searchAll(@ModelAttribute("cal")CalendarEntity cal,String start,String end){
		cal.setC_username(getCurrentUser().getC_username());
		List<CalendarEntity> list = calendarService.searchAll(cal);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return map;
    }
}
