package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Menu_Ca;

public interface IRole_MenuService extends IService<Role_Menu_Ca>{

	List<Role_Menu_Ca> findAll(int n_roleId);

	boolean update(Long roleId,String menuIds);

}
