package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.entity.CalendarEntity;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CalendarMapper extends SuperMapper<CalendarEntity>{

	boolean updateMy(CalendarEntity cal);

	List<CalendarEntity> searchAll(@Param("cal") CalendarEntity cal);
}
