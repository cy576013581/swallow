package com.cy.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.config.CacheConfig;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.system.UserMapper;
import com.cy.example.model.Page;
import com.cy.example.service.IUserService;
import com.cy.example.supplement.redis.RedisClient;
import com.cy.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisClient redisClinet;

	@CacheEvict(value = CacheConfig.CACHE_USER_USERNAME,key = "#user.c_username")
	public void delete(SysUserEntity user){
	}

	@CachePut(value = CacheConfig.CACHE_USER_USERNAME,key = "#user.c_username")
	public SysUserEntity insertMy(SysUserEntity user) {
		// TODO Auto-generated method stub
		if (null != user.getC_pwd() && "" != user.getC_pwd()) {
			user.setC_pwd(MD5Util.GetMD5Code(user.getC_pwd()));
		}else{
			user.setC_pwd(MD5Util.GetMD5Code("123456"));
		}
		this.userMapper.insertMy(user);
//		user = this.userMapper.findOneByUsername(user.getC_username());
		return user;
	}

	@CachePut(value = CacheConfig.CACHE_USER_USERNAME,key = "#user.c_username")
	public SysUserEntity updateMy(SysUserEntity user) {
		if (null != user.getC_pwd() && "" != user.getC_pwd()) {
			user.setC_pwd(MD5Util.GetMD5Code(user.getC_pwd()));
		}else{
			user.setC_pwd(null);
		}
		this.userMapper.updateMy(user);
		user = this.userMapper.findOneByUsername(user.getC_username());
		return user;
	}

	public List<SysUserEntity> searchAll(SysUserEntity user, Page page) {
		List<SysUserEntity> list = userMapper.searchAll(user, page);
		return list;
	}


	public int searchAllCount(SysUserEntity user) {
		// TODO Auto-generated method stub
		int sum = userMapper.searchAllCount(user);
		return sum;
	}

	@Cacheable(value = CacheConfig.CACHE_USER_USERNAME,key = "#username")
	public SysUserEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.findOneByUsername(username);
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		return userMapper.findAllCount();
	}

	public List<SysUserEntity> findAll(Page page) {
		// TODO Auto-generated method stub
		return userMapper.findAll(page);
	}

	@CachePut(value = CacheConfig.CACHE_USER_USERNAME,key = "#username")
	public SysUserEntity refreshByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.findOneByUsername(username);
	}
/*

    public void incrLoginCount(String key){
    	redisClinet.incr("loginCount:"+key);
    	if(Integer.valueOf(getLoginCount(key))  > 5){
    		expire("loginCount:"+key);
    	}
    }
    
    public String getLoginCount(String key){
    	String value = redisClinet.get("loginCount:"+key);
    	return value == null ? "-1":value;
    }
    
    public void expire(String key){
    	redisClinet.expire(key,300);
    }

    public void removeCount(String key){
    	redisClinet.del("loginCount:"+key);
    }
*/

}
