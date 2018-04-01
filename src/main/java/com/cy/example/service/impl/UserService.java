package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.system.UserMapper;
import com.cy.example.service.IUserService;
import com.cy.example.supplement.redis.RedisClient;
import com.cy.example.util.MD5Util;
import com.cy.example.util.StringUtil;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisClient redisClinet; 
	
	public boolean insertMy(SysUserEntity user) {
		// TODO Auto-generated method stub
		if (null != user.getC_pwd() && "" != user.getC_pwd()) {
			user.setC_pwd(MD5Util.GetMD5Code(user.getC_pwd()));
		}else{
			user.setC_pwd(MD5Util.GetMD5Code("123456"));
		}
		return this.userMapper.insertMy(user);
	}
	
	public boolean updateMy(SysUserEntity user) {
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
	
    public boolean insertUserCache(SysUserEntity entity) {  
        //非空  
        if(entity ==null || StringUtil.IsNullOrEmpty(String.valueOf(entity.getId()))){  
            return false;  
        }  
        
        redisClinet.setObject("user:"+entity.getC_username(), entity);  
        return true;
    }
    
    public SysUserEntity getUserCache(String username) {  
        //非空  
        if(username ==null || StringUtil.IsNullOrEmpty(username)){  
            return null;  
        }  
        
        return (SysUserEntity) redisClinet.getObject("user:"+username);
    }
    
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

}
