package com.cy.example.supplement.rabbitmq.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.example.entity.LoginRecordEntity;


@Component
public class RabbitSender {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	

	public void send(LoginRecordEntity loginRecord) {
		logger.info("发送对象信息: " + loginRecord.toString());
		this.rabbitTemplate.convertAndSend("loginRecord", loginRecord);
	}
	
}