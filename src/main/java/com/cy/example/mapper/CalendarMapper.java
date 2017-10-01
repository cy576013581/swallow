package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.entity.CalendarEntity;

@Mapper
public interface CalendarMapper extends SuperMapper<CalendarEntity>{

	int updateMy(CalendarEntity cal);

	List<CalendarEntity> searchAll(@Param("cal") CalendarEntity cal);
}
