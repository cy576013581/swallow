package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.User_Role_Ca;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface User_RoleMapper extends SuperMapper<User_Role_Ca> {

	int searchAllCount(@Param("ur") User_Role_Ca ur);

	List<User_Role_Ca> searchAll(
			@Param("ur") User_Role_Ca ur,
			@Param("page") PageCa page);
	
	int findAllCount(@Param("page") PageCa page);

	List<User_Role_Ca> findAll(@Param("page") PageCa page);
}
