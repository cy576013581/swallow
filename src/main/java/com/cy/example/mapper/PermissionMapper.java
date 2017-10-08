package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysPermissionEntity;

@Mapper
public interface PermissionMapper extends SuperMapper<SysPermissionEntity> {

	int searchAllCount(@Param("permission") SysPermissionEntity permission,
			@Param("page") PageCa page);

	List<SysPermissionEntity> searchAll(
			@Param("permission") SysPermissionEntity role,
			@Param("page") PageCa page);
}
