package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysDepartmentEntity;

public interface IDepartmentService extends IService<SysDepartmentEntity> {
	
	List<SysDepartmentEntity> searchAll(SysDepartmentEntity depart, PageCa page);

	int searchAllCount(SysDepartmentEntity depart);
}
