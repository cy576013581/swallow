package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.dao.CalendarMapper;
import com.cy.example.domain.Calendar;
import com.cy.example.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarMapper CalendarMapper;
	
	public int add(Calendar cal) {
		return this.CalendarMapper.add(cal);
    }
	public int update(Calendar cal) {
		return this.CalendarMapper.update(cal);
	}
	public int delete(Long id) {
		return this.CalendarMapper.delete(id);
	}
	public Calendar findCalendarById(Long id) {
		return this.CalendarMapper.findCalendarById(id);
	}
	public List<Calendar> findCalendars() {
		return this.CalendarMapper.findCalendars();
	}
}
