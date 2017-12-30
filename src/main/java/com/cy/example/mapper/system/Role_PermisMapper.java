package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface Role_PermisMapper extends SuperMapper<Role_Permis_Ca> {

	int searchAllCount(@Param("rp") Role_Permis_Ca rp);

	List<Role_Permis_Ca> searchAll(
			@Param("rp") Role_Permis_Ca rp,
			@Param("page") PageCa page);
	
	int findAllCount(@Param("page") PageCa page);

	List<Role_Permis_Ca> findAll(@Param("page") PageCa page);
}
