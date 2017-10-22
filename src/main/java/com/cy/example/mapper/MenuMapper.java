package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.SysMenuEntity;

@Mapper
public interface MenuMapper extends SuperMapper<SysMenuEntity>{

	int searchAllCount(@Param("menu") SysMenuEntity menu,
			@Param("page") PageCa page);

	List<SysMenuEntity> searchAll(
			@Param("menu") SysMenuEntity menu,
			@Param("page") PageCa page);
	
	List<SysMenuEntity> findRoot();
	
	List<SysMenuEntity> findAll();
//	SysMenuEntity findMenuByNode(@Param("menu") SysMenuEntity menu);
}
