package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Permis_Ca;

public interface IRole_PermisService extends IService<Role_Permis_Ca> {
	
	List<Role_Permis_Ca> searchAll(Role_Permis_Ca rp, Page page);

	int searchAllCount(Role_Permis_Ca rp);
	
	int findAllCount(Page page);

	List<Role_Permis_Ca> findAll(Page page);
}
