package com.cy.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.example.entity.MailEntity;
import com.cy.example.service.impl.MailServiceImpl;
import com.cy.example.supplement.redis.RedisClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisClient redis;

    @Test
    public void redisSet() throws Exception {
    	redis.set("username", "swallow");
    	System.out.println("设置成功！");
    }
    
}