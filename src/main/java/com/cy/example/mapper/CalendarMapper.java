package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.example.entity.CalendarEntity;

@Mapper
public interface CalendarMapper {

	@Insert("insert into Calendars(c_username, c_title,d_start,d_end,n_level) values(#{cal.c_username},"
			+ " #{cal.c_title},#{cal.d_start},#{cal.d_end},#{cal.n_level})")
    int add(@Param("Calendar") CalendarEntity cal);
 
    @Update("update Calendars set c_username = #{cal.c_username}, c_pwd = #{cal.c_pwd}"
    		+ ", c_phone = #{cal.c_phone}, n_age = #{cal.n_age}, n_sex = #{cal.n_sex} where id = #{cal.id}")
    int update(@Param("Calendar") CalendarEntity cal);
 
    @Delete("delete from Calendars where id = #{id}")
    int delete(Long id);
 
    @Select("select id,c_username,c_title,d_start,d_end,n_level from Calendars where id = #{id}")
    CalendarEntity findCalendarById(@Param("id") Long id);
 
    @Select("select id,c_username,c_title,d_start,d_end,n_level from Calendars")
    List<CalendarEntity> findCalendars();
}
