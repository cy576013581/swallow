package com.cy.example.mapper.system;

import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Role_PermisMapper extends SuperMapper<Role_Permis_Ca> {

	List<Role_Permis_Ca> findAll(@Param("n_roleId")int n_roleId);

	boolean update(@Param("list")List<Role_Permis_Ca> list);
}
