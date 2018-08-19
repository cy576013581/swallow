package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysUserEntity;

public interface IUserService extends IService<SysUserEntity>{
	
	public SysUserEntity updateMy(SysUserEntity user);
	
	public SysUserEntity insertMy(SysUserEntity user);

	public SysUserEntity findOneByUsername(String username);

	public int searchAllCount(SysUserEntity user);

	public List<SysUserEntity> searchAll(SysUserEntity user, Page page);
	
	public int findAllCount();

	public List<SysUserEntity> findAll(Page page);

	SysUserEntity refreshByUsername(String username);

//	SysUserEntity getUserCache(String username);
//
//	boolean insertUserCache(SysUserEntity entity);
//
//	public void incrLoginCount(String key);
//
//	public String getLoginCount(String key);
//
//	public void expire(String key);
//
//	public void removeCount(String key);
	
}
