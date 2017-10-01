package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LoginRecordEntity;

public interface ILoginRecordService extends IService<LoginRecordEntity> {
	
	List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord, PageCa page);

	int searchAllCount(LoginRecordEntity loginRecord, PageCa page);
}
