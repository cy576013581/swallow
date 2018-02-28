package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface LoginRecordMapper extends SuperMapper<LoginRecordEntity> {

	int searchAllCount(@Param("loginRecord") LoginRecordEntity loginRecord);

	List<LoginRecordEntity> searchAll(
			@Param("loginRecord") LoginRecordEntity loginRecord,
			@Param("page") PageCa page);
	
	public int recentLoginCount(String date);
}
