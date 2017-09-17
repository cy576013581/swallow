package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.example.entity.CalendarEntity;
import com.cy.example.entity.UserEntity;

@Mapper
public interface CalendarMapper {

    int add(CalendarEntity cal);
 
    int update(CalendarEntity cal);
 
    int delete(Long id);
 
    List<CalendarEntity> searchAll(@Param("cal")CalendarEntity cal);
}
