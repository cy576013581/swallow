package com.cy.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cy.example.carrier.PageCar;
import com.cy.example.entity.UserEntity;

public interface UserService {

	public int add(UserEntity user);
	
	public int update(UserEntity user);
	
	public int delete(Long id);
	
	public UserEntity validate(UserEntity user);
	
	public UserEntity findUserById(Long id);
	
	public UserEntity findOneByUsername(String username);
	
	public List<UserEntity> findAll(PageCar page);
	
	public int findAllCount(PageCar page);
	
	public int searchAllCount(UserEntity user,PageCar page);
    
	public List<UserEntity> searchAll(UserEntity user,PageCar page);
}
