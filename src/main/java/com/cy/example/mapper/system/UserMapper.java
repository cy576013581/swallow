package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface UserMapper extends SuperMapper<SysUserEntity>{
	
	int updateMy(SysUserEntity user);

	SysUserEntity validate(String username, String pwd);

	SysUserEntity findOneByUsername(String username);

	int searchAllCount(@Param("user") SysUserEntity user);

	List<SysUserEntity> searchAll(@Param("user") SysUserEntity user,
			@Param("page") PageCa page);
	
	int findAllCount();

	List<SysUserEntity> findAll(@Param("page") PageCa page);
}
