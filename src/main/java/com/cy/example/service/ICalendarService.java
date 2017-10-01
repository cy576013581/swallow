package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.entity.CalendarEntity;

public interface ICalendarService extends IService<CalendarEntity>{

	public int updateMy(CalendarEntity cal);
	
	public List<CalendarEntity> searchAll(CalendarEntity cal);
}
