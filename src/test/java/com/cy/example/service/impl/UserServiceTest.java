package com.cy.example.service.impl;

import com.cy.example.ApplicationTest;
import com.cy.example.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @description: ${description}
 * @author: chenyang
 * @create: 2019-01-22
 **/
public class UserServiceTest extends ApplicationTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        System.out.println(userService.findAllCount());
    }

}