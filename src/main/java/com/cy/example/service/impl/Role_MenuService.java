package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.mapper.system.Role_MenuMapper;
import com.cy.example.service.IRole_MenuService;

@Service
public class Role_MenuService extends ServiceImpl<Role_MenuMapper, Role_Menu_Ca>
	implements IRole_MenuService{
	
	@Autowired
	private Role_MenuMapper mapper;

	public List<Role_Menu_Ca> findAll(int n_roleId) {
		// TODO Auto-generated method stub
		return mapper.findAll(n_roleId);
	}

	
}
