package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LeaveBillEntity;

public interface ILeaveBillService extends IService<LeaveBillEntity>{

	public List<LeaveBillEntity> findAll(PageCa page);

	public int findAllCount();
	
	public List<LeaveBillEntity> searchAll(LeaveBillEntity bill, PageCa page);

	public int searchAllCount(LeaveBillEntity bill);
	
	public boolean updateMy(LeaveBillEntity bill);
}
