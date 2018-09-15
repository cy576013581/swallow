package com.cy.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.Role_Permis_Ca;

import java.util.List;

public interface IRole_PermisService extends IService<Role_Permis_Ca> {

	List<Role_Permis_Ca> findAll(int n_roleId);

	boolean update(Long roleId,String menuIds);
}
