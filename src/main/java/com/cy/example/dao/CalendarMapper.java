package com.cy.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.example.entity.Calendar;


@Mapper
public interface CalendarMapper {

	@Insert("insert into Calendars(c_username, c_title,d_start,d_end,n_level) values(#{cal.c_username},"
			+ " #{cal.c_title},#{cal.d_start},#{cal.d_end},#{cal.n_level})")
    int add(@Param("Calendar") Calendar cal);
 
    @Update("update Calendars set c_username = #{cal.c_username}, c_pwd = #{cal.c_pwd}"
    		+ ", c_phone = #{cal.c_phone}, n_age = #{cal.n_age}, n_sex = #{cal.n_sex} where id = #{cal.id}")
    int update(@Param("Calendar") Calendar cal);
 
    @Delete("delete from Calendars where id = #{id}")
    int delete(Long id);
 
    @Select("select id,c_username,c_title,d_start,d_end,n_level from Calendars where id = #{id}")
    Calendar findCalendarById(@Param("id") Long id);
 
    @Select("select id,c_username,c_title,d_start,d_end,n_level from Calendars")
    List<Calendar> findCalendars();
}
