package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.mapper.system.DepartmentMapper;
import com.cy.example.service.IDepartmentService;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, SysDepartmentEntity>
	implements IDepartmentService{
	
	@Autowired
	private DepartmentMapper departmentMapper;

	public List<SysDepartmentEntity> searchAll(SysDepartmentEntity depart,
			PageCa page) {
		// TODO Auto-generated method stub
		return departmentMapper.searchAll(depart, page);
	}

	public int searchAllCount(SysDepartmentEntity depart) {
		// TODO Auto-generated method stub
		return departmentMapper.searchAllCount(depart);
	}
	

}
