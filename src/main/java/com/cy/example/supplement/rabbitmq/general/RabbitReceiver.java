package com.cy.example.supplement.rabbitmq.general;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.MailEntity;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IMailService;
import com.cy.example.util.HttpRequestUtil;

@Slf4j
@Configuration
public class RabbitReceiver {

//
//	@Autowired
//	private ILoginRecordService loginRecordService;
//
//	@Autowired
//	private IMailService mailService;
//
//	@RabbitListener(queues = "loginRecord")
//    public void insertLoginRecord(LoginRecordEntity loginRecord) {
//		log.info("接收到object : " + loginRecord);
//		loginRecordService.insert(loginRecord);
//    }
//
//	@RabbitListener(queues = "mail")
//    public void process(MailEntity mail) {
//		log.info("接收到object : " + mail);
//		mailService.sendSimpleMail(mail);
//    }

}
