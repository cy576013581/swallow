package com.cy.example.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.entity.UserEntity;
import com.cy.example.mapper.UserMapper;
import com.cy.example.service.UserService;
import com.cy.example.utils.SecrecyUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public int add(UserEntity user) {
		user.setC_pwd(SecrecyUtil.encryptBasedDes(user.getC_pwd()));
		return this.userMapper.add(user);
    }
	public int update(UserEntity user) {
		if(null != user.getC_pwd() || "" != user.getC_pwd()){
			user.setC_pwd(SecrecyUtil.encryptBasedDes(user.getC_pwd()));
		}
		return this.userMapper.update(user);
	}
	public int delete(Long id) {
		return this.userMapper.delete(id);
	}
	public UserEntity findUserById(Long id) {
		return this.userMapper.findOneById(id);
	}
	public List<UserEntity> findUsers() {
		return this.userMapper.findAll();
	}
	public UserEntity validate(UserEntity user) {
		// TODO Auto-generated method stub
		user.setC_pwd(SecrecyUtil.encryptBasedDes(user.getC_pwd()));
		return this.userMapper.validate(user);
	}
	
	public List<UserEntity> searchData(UserEntity obj) {
		List<UserEntity> list = userMapper.searchAll(obj);
		return list;
	}
}
