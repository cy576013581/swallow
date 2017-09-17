package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.entity.CalendarEntity;
import com.cy.example.mapper.CalendarMapper;
import com.cy.example.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarMapper calendarMapper;
	
	public int add(CalendarEntity cal) {
		return this.calendarMapper.add(cal);
    }
	public int update(CalendarEntity cal) {
		return this.calendarMapper.update(cal);
	}
	public int delete(Long id) {
		return this.calendarMapper.delete(id);
	}
	public List<CalendarEntity> searchAll(CalendarEntity cal) {
		return this.calendarMapper.searchAll(cal);
	}
}
