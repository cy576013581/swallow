package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.workflow.LeaveBillEntity;

public interface ILeaveBillService extends IService<LeaveBillEntity>{

	public List<LeaveBillEntity> findAll(Page page);

	public int findAllCount();
	
	public List<LeaveBillEntity> searchAll(LeaveBillEntity bill, Page page);

	public int searchAllCount(LeaveBillEntity bill);
	
	public boolean updateMy(LeaveBillEntity bill);
	
	public boolean insertMy(LeaveBillEntity bill);
}
