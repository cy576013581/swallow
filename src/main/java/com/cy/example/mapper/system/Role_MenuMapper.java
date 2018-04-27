package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.mapper.SuperMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Role_MenuMapper extends SuperMapper<Role_Menu_Ca> {

	List<Role_Menu_Ca> findAll(@Param("n_roleId")int n_roleId);

	boolean update(@Param("list")List<Role_Menu_Ca> list);
}
