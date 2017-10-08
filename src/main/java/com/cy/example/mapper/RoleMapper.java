package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysRoleEntity;

@Mapper
public interface RoleMapper extends SuperMapper<SysRoleEntity> {

	int searchAllCount(@Param("role") SysRoleEntity role,
			@Param("page") PageCa page);

	List<SysRoleEntity> searchAll(
			@Param("role") SysRoleEntity role,
			@Param("page") PageCa page);
}
