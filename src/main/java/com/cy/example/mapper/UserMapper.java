package com.cy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.carrier.PageCar;
import com.cy.example.entity.UserEntity;

@Mapper
public interface UserMapper {

	int add(UserEntity user);

	int update(UserEntity user);

	int delete(Long id);

	UserEntity validate(String username, String pwd);

	UserEntity findOneById(Long id);

	UserEntity findOneByUsername(String username);

	List<UserEntity> findAll(@Param("page") PageCar page);

	int findAllCount(@Param("page") PageCar page);

	int searchAllCount(@Param("user") UserEntity user,
			@Param("page") PageCar page);

	List<UserEntity> searchAll(@Param("user") UserEntity user,
			@Param("page") PageCar page);
}
