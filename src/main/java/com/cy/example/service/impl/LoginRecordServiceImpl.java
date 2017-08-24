package com.cy.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.mapper.LoginRecordMapper;
import com.cy.example.service.LoginRecordService;

@Service
public class LoginRecordServiceImpl implements LoginRecordService{

	@Autowired
	private LoginRecordMapper loginRecordMapper;
	
	public int add(LoginRecordEntity loginRecord) {
		// TODO Auto-generated method stub
		return loginRecordMapper.add(loginRecord);
	}

}
