package com.cy.example.service;

import java.util.List;


import com.cy.example.entity.CalendarEntity;

public interface CalendarService {

	public int add(CalendarEntity cal);
	
	public int update(CalendarEntity cal);
	
	public int delete(Long id);
	
	public List<CalendarEntity> searchAll(CalendarEntity cal);
}
