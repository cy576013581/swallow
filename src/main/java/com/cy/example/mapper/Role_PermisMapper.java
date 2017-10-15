package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Permis_Ca;

@Mapper
public interface Role_PermisMapper extends SuperMapper<Role_Permis_Ca> {

	int searchAllCount(@Param("rp") Role_Permis_Ca rp,
			@Param("page") PageCa page);

	List<Role_Permis_Ca> searchAll(
			@Param("rp") Role_Permis_Ca rp,
			@Param("page") PageCa page);
	
	int findAllCount(@Param("page") PageCa page);

	List<Role_Permis_Ca> findAll(@Param("page") PageCa page);
}
