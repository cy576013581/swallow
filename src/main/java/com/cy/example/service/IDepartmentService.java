package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysDepartmentEntity;

public interface IDepartmentService extends IService<SysDepartmentEntity> {
	
	List<SysDepartmentEntity> searchAll(SysDepartmentEntity depart, Page page);

	int searchAllCount(SysDepartmentEntity depart);
}
