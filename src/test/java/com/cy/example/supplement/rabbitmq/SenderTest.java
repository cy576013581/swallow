package com.cy.example.supplement.rabbitmq;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.example.entity.UserEntity;
import com.cy.example.supplement.rabbitmq.general.RabbitSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {

	@Autowired
	private RabbitSender sender;

	@Test
	public void sendOject() throws Exception {
		UserEntity user=new UserEntity();
		user.setC_username("swallow");
		sender.send(user);
	}

}