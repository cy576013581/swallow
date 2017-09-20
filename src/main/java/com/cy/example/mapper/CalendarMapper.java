package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.entity.CalendarEntity;

@Mapper
public interface CalendarMapper {

	int add(CalendarEntity cal);

	int update(CalendarEntity cal);

	int delete(Long id);

	List<CalendarEntity> searchAll(@Param("cal") CalendarEntity cal);
}
