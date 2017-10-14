package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.User_Role_Ca;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.mapper.RoleMapper;
import com.cy.example.mapper.User_RoleMapper;
import com.cy.example.service.IUser_RoleService;

@Service
public class User_RoleServiceImpl extends ServiceImpl<User_RoleMapper, User_Role_Ca>
	implements IUser_RoleService{
	
	@Autowired
	private User_RoleMapper mapper;

	public List<User_Role_Ca> searchAll(User_Role_Ca ur, PageCa page) {
		// TODO Auto-generated method stub
		return mapper.searchAll(ur, page);
	}

	public int searchAllCount(User_Role_Ca ur, PageCa page) {
		// TODO Auto-generated method stub
		return mapper.searchAllCount(ur, page);
	}

	public int findAllCount(PageCa page) {
		// TODO Auto-generated method stub
		return mapper.findAllCount(page);
	}

	public List<User_Role_Ca> findAll(PageCa page) {
		// TODO Auto-generated method stub
		return mapper.findAll(page);
	}
	
}
