package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.system.UserMapper;
import com.cy.example.service.IUserService;
import com.cy.example.util.MD5Util;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public int updateMy(SysUserEntity user) {
		if (null != user.getC_pwd() && "" != user.getC_pwd()) {
			user.setC_pwd(MD5Util.GetMD5Code(user.getC_pwd()));
		}else{
			user.setC_pwd(null);
		}
		return this.userMapper.updateMy(user);
	}

	public List<SysUserEntity> searchAll(SysUserEntity user, PageCa page) {
		List<SysUserEntity> list = userMapper.searchAll(user, page);
		return list;
	}


	public int searchAllCount(SysUserEntity user) {
		// TODO Auto-generated method stub
		int sum = userMapper.searchAllCount(user);
		return sum;
	}

	public SysUserEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.findOneByUsername(username);
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		return userMapper.findAllCount();
	}

	public List<SysUserEntity> findAll(PageCa page) {
		// TODO Auto-generated method stub
		return userMapper.findAll(page);
	}

}
