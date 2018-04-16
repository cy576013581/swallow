package com.cy.example.mapper.workflow;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.workflow.LeaveBillEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface LeaveBillMapper extends SuperMapper<LeaveBillEntity> {

	public int findAllCount();

	public List<LeaveBillEntity> findAll(@Param("page") Page page);

	public boolean updateMy(@Param("bill")LeaveBillEntity bill);
	
	public boolean insertMy(@Param("bill")LeaveBillEntity bill);
	
	public LeaveBillEntity findOneById(@Param("id")int id);
}
