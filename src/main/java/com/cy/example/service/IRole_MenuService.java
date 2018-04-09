package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Menu_Ca;

public interface IRole_MenuService extends IService<Role_Menu_Ca>{

	List<Role_Menu_Ca> searchAll(Role_Menu_Ca rm, PageCa page);

	int searchAllCount(Role_Menu_Ca rp);
	
	int findAllCount(PageCa page);

	List<Role_Menu_Ca> findAll(PageCa page);
}
