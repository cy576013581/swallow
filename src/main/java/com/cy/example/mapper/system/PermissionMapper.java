package com.cy.example.mapper.system;

import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.mapper.SuperMapper;
import com.cy.example.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper extends SuperMapper<SysPermissionEntity> {

	int searchAllCount(@Param("permission") SysPermissionEntity permission);

	List<SysPermissionEntity> searchAll(
			@Param("permission") SysPermissionEntity role,
			@Param("page") Page page);

	List<SysPermissionEntity> findAll();
}
