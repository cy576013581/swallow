package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface MenuMapper extends SuperMapper<SysMenuEntity>{

	int searchAllCount(@Param("menu") SysMenuEntity menu);

	List<SysMenuEntity> searchAll(
			@Param("menu") SysMenuEntity menu,
			@Param("page") Page page);
	
	List<SysMenuEntity> findRoot();
	
	List<SysMenuEntity> findAll();
//	SysMenuEntity findMenuByNode(@Param("menu") SysMenuEntity menu);

	List<SysMenuEntity> findUserAll(@Param("roleId")Long roleId);
}
