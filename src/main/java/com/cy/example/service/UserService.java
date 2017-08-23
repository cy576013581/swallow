package com.cy.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.example.entity.UserEntity;

public interface UserService {

	public int add(UserEntity user);
	
	public int update(UserEntity user);
	
	public int delete(Long id);
	
	public UserEntity validate(UserEntity user);
	
	public UserEntity findUserById(Long id);
	
	public List<UserEntity> findUsers();
	
	public List<UserEntity> searchData(UserEntity obj);
}
