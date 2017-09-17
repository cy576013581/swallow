package com.cy.example.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.example.entity.UserEntity;
import com.cy.example.mapper.UserMapper;

public class CredentialsMatcher extends SimpleCredentialsMatcher{

	@Autowired
	private UserMapper userMapper;
	
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(utoken.getPassword());
        //获得数据库中的密码
        
        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        boolean flag = false;
        if(this.equals(inPassword, dbPassword)){
        	flag = true;
        	PrincipalCollection principals = info.getPrincipals();
        	UserEntity user  = (UserEntity)principals.getPrimaryPrincipal();
        	SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
        }
        return flag;
    }
    
}