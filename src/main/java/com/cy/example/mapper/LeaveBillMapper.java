package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.LeaveBillEntity;

@Mapper
public interface LeaveBillMapper extends SuperMapper<LeaveBillEntity> {

	public int findAllCount();

	public List<LeaveBillEntity> findAll(@Param("page") PageCa page);

	public boolean updateMy(@Param("bill")LeaveBillEntity bill);
}
