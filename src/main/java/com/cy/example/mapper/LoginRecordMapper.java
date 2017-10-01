package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LoginRecordEntity;

@Mapper
public interface LoginRecordMapper extends SuperMapper<LoginRecordEntity> {

	int searchAllCount(@Param("loginRecord") LoginRecordEntity loginRecord,
			@Param("page") PageCa page);

	List<LoginRecordEntity> searchAll(
			@Param("loginRecord") LoginRecordEntity loginRecord,
			@Param("page") PageCa page);
}
