package com.cy.example.service;

import java.util.List;

import com.cy.example.Vo.PageVo;
import com.cy.example.entity.LoginRecordEntity;

public interface LoginRecordService {
	
	int add(LoginRecordEntity loginRecord);
	
	public List<LoginRecordEntity> findAll(PageVo page);
	
	public int findAllCount(PageVo page);

	List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord, PageVo page);

	int searchAllCount(LoginRecordEntity loginRecord, PageVo page);
}
