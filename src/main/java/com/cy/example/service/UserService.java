package com.cy.example.service;

import java.util.List;

import com.cy.example.entity.User;

public interface UserService {

	public int add(User user);
	
	public int update(User user);
	
	public int delete(Long id);
	
	public User validate(User user);
	
	public User findUserById(Long id);
	
	public List<User> findUsers();
	
	public List<User> searchData(User obj);
}
