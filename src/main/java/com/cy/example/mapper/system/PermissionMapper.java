package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface PermissionMapper extends SuperMapper<SysPermissionEntity> {

	int searchAllCount(@Param("permission") SysPermissionEntity permission);

	List<SysPermissionEntity> searchAll(
			@Param("permission") SysPermissionEntity role,
			@Param("page") Page page);
}
