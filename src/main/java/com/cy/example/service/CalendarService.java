package com.cy.example.service;

import java.util.List;

import com.cy.example.entity.Calendar;

public interface CalendarService {

	public int add(Calendar cal);
	
	public int update(Calendar cal);
	
	public int delete(Long id);
	
	public Calendar findCalendarById(Long id);
	
	public List<Calendar> findCalendars();
}
