package com.cy.example.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.Vo.PageVo;
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
	public List<UserEntity> findAll(PageVo page) {
		return this.userMapper.findAll(page);
	}
	public UserEntity validate(UserEntity user) {
		// TODO Auto-generated method stub
		user.setC_pwd(SecrecyUtil.encryptBasedDes(user.getC_pwd()));
		return this.userMapper.validate(user);
	}
	
	public List<UserEntity> searchAll(UserEntity user,PageVo page) {
		List<UserEntity> list = userMapper.searchAll(user,page);
		return list;
	}
	
	public int findAllCount(PageVo page){
		int sum = userMapper.findAllCount(page);
		return sum;
	}
	public int searchAllCount(UserEntity user, PageVo page) {
		// TODO Auto-generated method stub
		int sum = userMapper.searchAllCount(user,page);
		return sum;
	}
}
