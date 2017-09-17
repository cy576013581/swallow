package com.cy.example.service;

import java.util.List;

import com.cy.example.carrier.PageCar;
import com.cy.example.entity.LoginRecordEntity;

public interface LoginRecordService {
	
	int add(LoginRecordEntity loginRecord);
	
	public List<LoginRecordEntity> findAll(PageCar page);
	
	public int findAllCount(PageCar page);

	List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord, PageCar page);

	int searchAllCount(LoginRecordEntity loginRecord, PageCar page);
}
