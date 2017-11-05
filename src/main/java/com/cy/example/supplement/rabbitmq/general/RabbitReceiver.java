package com.cy.example.supplement.rabbitmq.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cy.example.controller.UserController;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.service.ILoginRecordService;

@Configuration
public class RabbitReceiver {

	private static final Logger logger = LoggerFactory
			.getLogger(RabbitReceiver.class);
	
	@Autowired
	private ILoginRecordService loginRecordService;
	
	@RabbitListener(queues = "loginRecord")
    public void process(LoginRecordEntity loginRecord) {
		logger.info("接收到object : " + loginRecord);
		loginRecordService.insert(loginRecord);
    }

}
