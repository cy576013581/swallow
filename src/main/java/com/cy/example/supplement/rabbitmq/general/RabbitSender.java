package com.cy.example.supplement.rabbitmq.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.example.config.RabbitConfig;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.entity.MailEntity;


@Component
public class RabbitSender {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void sendLoginRecord(LoginRecordEntity loginRecord) {
		logger.info("发送对象信息: " + loginRecord.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_LOGINRECORD, loginRecord);
	}
	
	public void sendMail(MailEntity mail) {
		logger.info("发送对象信息: " + mail.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_MAIL, mail);
	}
	
}