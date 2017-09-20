package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCar;
import com.cy.example.entity.LoginRecordEntity;

@Mapper
public interface LoginRecordMapper {

	int add(LoginRecordEntity loginRecord);

	// int update(LoginRecordEntity loginRecord);
	//
	// int delete(Long id);

	// LoginRecordEntity findOneById(Long id);

	List<LoginRecordEntity> findAll(@Param("page") PageCar page);

	int findAllCount(@Param("page") PageCar page);

	int searchAllCount(@Param("loginRecord") LoginRecordEntity loginRecord,
			@Param("page") PageCar page);

	List<LoginRecordEntity> searchAll(
			@Param("loginRecord") LoginRecordEntity loginRecord,
			@Param("page") PageCar page);
}
