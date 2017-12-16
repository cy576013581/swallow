package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.mapper.LeaveBillMapper;
import com.cy.example.mapper.RoleMapper;
import com.cy.example.service.ILeaveBillService;

@Service
public class LeaveBillServiceImpl extends ServiceImpl<LeaveBillMapper, LeaveBillEntity>
	implements ILeaveBillService{
	
	@Autowired
	private LeaveBillMapper billMapper;
	

	public List<LeaveBillEntity> findAll(PageCa page) {
		// TODO Auto-generated method stub
		return billMapper.findAll(page);
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		return billMapper.findAllCount();
	}

	public List<LeaveBillEntity> searchAll(LeaveBillEntity bill, PageCa page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int searchAllCount(LeaveBillEntity bill) {
		// TODO Auto-generated method stub
		return 0;
	}
}
