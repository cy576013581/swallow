package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCa;
import com.cy.example.entity.UserEntity;

@Mapper
public interface UserMapper extends SuperMapper<UserEntity>{
	
	int updateMy(UserEntity user);

	UserEntity validate(String username, String pwd);

	UserEntity findOneByUsername(String username);

	int searchAllCount(@Param("user") UserEntity user,
			@Param("page") PageCa page);

	List<UserEntity> searchAll(@Param("user") UserEntity user,
			@Param("page") PageCa page);
}
