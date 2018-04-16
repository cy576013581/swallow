package com.cy.example.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.LoginRecordEntity;

public interface ILoginRecordService extends IService<LoginRecordEntity> {
	
	List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord, Page page);

	int searchAllCount(LoginRecordEntity loginRecord);

	Map<String, Object> recentLoginCount();
}
