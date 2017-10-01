package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.UserEntity;
import com.cy.example.mapper.UserMapper;
import com.cy.example.service.IUserService;
import com.cy.example.utils.MD5Util;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public int updateMy(UserEntity user) {
		if (null != user.getC_pwd() || "" != user.getC_pwd()) {
			user.setC_pwd(MD5Util.GetMD5Code(user.getC_pwd()));
		}
		return this.userMapper.updateMy(user);
	}

	public List<UserEntity> searchAll(UserEntity user, PageCa page) {
		List<UserEntity> list = userMapper.searchAll(user, page);
		return list;
	}


	public int searchAllCount(UserEntity user, PageCa page) {
		// TODO Auto-generated method stub
		int sum = userMapper.searchAllCount(user, page);
		return sum;
	}

	public UserEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.findOneByUsername(username);
	}

}
