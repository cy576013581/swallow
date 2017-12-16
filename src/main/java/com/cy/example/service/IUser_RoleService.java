package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.User_Role_Ca;

public interface IUser_RoleService extends IService<User_Role_Ca> {
	
	List<User_Role_Ca> searchAll(User_Role_Ca ur, PageCa page);

	int searchAllCount(User_Role_Ca ur);
	
	int findAllCount(PageCa page);

	List<User_Role_Ca> findAll(PageCa page);
}
