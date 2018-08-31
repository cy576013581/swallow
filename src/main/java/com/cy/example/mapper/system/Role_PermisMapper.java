package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.mapper.SuperMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Role_PermisMapper extends SuperMapper<Role_Permis_Ca> {

	int searchAllCount(@Param("rp") Role_Permis_Ca rp);

	List<Role_Permis_Ca> searchAll(
			@Param("rp") Role_Permis_Ca rp,
			@Param("page") Page page);
	
	int findAllCount(@Param("page") Page page);

	List<Role_Permis_Ca> findAll(@Param("page") Page page);
}
