package com.cy.example.supplement.rabbitmq.general;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.example.entity.LoginRecordEntity;


@Component
public class RabbitSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(LoginRecordEntity user) {
		System.out.println("Sender object: " + user.toString());
		this.rabbitTemplate.convertAndSend("loginRecord", user);
	}

}