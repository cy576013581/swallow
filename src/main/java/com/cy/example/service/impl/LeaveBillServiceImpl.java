package com.cy.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.LeaveBillEntity;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.mapper.LeaveBillMapper;
import com.cy.example.mapper.RoleMapper;
import com.cy.example.service.ILeaveBillService;
import com.cy.example.service.IWorkFlowService;

@Service
public class LeaveBillServiceImpl extends ServiceImpl<LeaveBillMapper, LeaveBillEntity>
	implements ILeaveBillService{
	
	@Autowired
	private LeaveBillMapper billMapper;
	
	@Autowired
	private IWorkFlowService workFlowService;
	

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
	
	@Transactional
	public boolean updateMy(LeaveBillEntity bill) {
		// TODO Auto-generated method stub
		//2、启动流程实例
		workFlowService.startProcessDefinition(bill);
		//1、更新状态
		billMapper.updateMy(bill);
		
		
		return true;
	}
}
