package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.SuperMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends SuperMapper<SysUserEntity>{
	
	boolean updateMy(@Param("user")SysUserEntity user);
	
	boolean insertMy(@Param("user")SysUserEntity user);

	SysUserEntity validate(String username, String pwd);

	SysUserEntity findOneByUsername(String username);

	int searchAllCount(@Param("user") SysUserEntity user);

	List<SysUserEntity> searchAll(@Param("user") SysUserEntity user,
			@Param("page") Page page);
	
	int findAllCount();

	List<SysUserEntity> findAll(@Param("page") Page page);
}
