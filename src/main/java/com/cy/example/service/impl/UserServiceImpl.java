package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.dao.UserMapper;
import com.cy.example.domain.User;
import com.cy.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public int add(User user) {
		return this.userMapper.add(user);
    }
	public int update(User user) {
		return this.userMapper.update(user);
	}
	public int delete(Long id) {
		return this.userMapper.delete(id);
	}
	public User findUserById(Long id) {
		return this.userMapper.findUserById(id);
	}
	public List<User> findUsers() {
		return this.userMapper.findUsers();
	}
	public User validate(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.validate(user);
	}
}
