package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface Role_MenuMapper extends SuperMapper<Role_Menu_Ca> {

	int searchAllCount(@Param("rm") Role_Menu_Ca rm);

	List<Role_Menu_Ca> searchAll(
            @Param("rm") Role_Menu_Ca rm,
            @Param("page") Page page);
	
	int findAllCount(@Param("page") Page page);

	List<Role_Menu_Ca> findAll(@Param("page") Page page);
}
