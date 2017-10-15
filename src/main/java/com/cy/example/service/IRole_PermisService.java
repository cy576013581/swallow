package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Permis_Ca;

public interface IRole_PermisService extends IService<Role_Permis_Ca> {
	
	List<Role_Permis_Ca> searchAll(Role_Permis_Ca rp, PageCa page);

	int searchAllCount(Role_Permis_Ca rp, PageCa page);
	
	int findAllCount(PageCa page);

	List<Role_Permis_Ca> findAll(PageCa page);
}
