package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.UserEntity;

public interface IUserService extends IService<UserEntity>{
	
	public int updateMy(UserEntity user);

	public UserEntity findOneByUsername(String username);

	public int searchAllCount(UserEntity user, PageCa page);

	public List<UserEntity> searchAll(UserEntity user, PageCa page);
}
