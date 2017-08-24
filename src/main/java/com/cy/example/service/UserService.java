package com.cy.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cy.example.Vo.PageVo;
import com.cy.example.entity.UserEntity;

public interface UserService {

	public int add(UserEntity user);
	
	public int update(UserEntity user);
	
	public int delete(Long id);
	
	public UserEntity validate(UserEntity user);
	
	public UserEntity findUserById(Long id);
	
	public List<UserEntity> findAll(PageVo page);
	
	public int findAllCount(PageVo page);
	
	public int searchAllCount(UserEntity user,PageVo page);
    
	public List<UserEntity> searchAll(UserEntity user,PageVo page);
}
