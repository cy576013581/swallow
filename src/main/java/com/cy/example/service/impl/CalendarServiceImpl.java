package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.entity.CalendarEntity;
import com.cy.example.mapper.CalendarMapper;
import com.cy.example.service.ICalendarService;

@Service
public class CalendarServiceImpl extends ServiceImpl<CalendarMapper, CalendarEntity>
	implements ICalendarService{

	@Autowired
	private CalendarMapper calendarMapper;
	
	public int updateMy(CalendarEntity cal) {
		return this.calendarMapper.updateMy(cal);
	}
	
	public List<CalendarEntity> searchAll(CalendarEntity cal) {
		return this.calendarMapper.searchAll(cal);
	}
}
