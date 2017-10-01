package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.mapper.LoginRecordMapper;
import com.cy.example.service.ILoginRecordService;

@Service
public class LoginRecordServiceImpl extends ServiceImpl<LoginRecordMapper, LoginRecordEntity>
	implements ILoginRecordService{
	
	@Autowired
	private LoginRecordMapper loginRecordMapper;
	

	public List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord,
			PageCa page) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAll(loginRecord, page);
	}

	public int searchAllCount(LoginRecordEntity loginRecord, PageCa page) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAllCount(loginRecord, page);
	}
}
