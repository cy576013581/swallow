package com.cy.example.supplement.rabbitmq.general;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cy.example.vo.IpAnalysisVo_Sina;
import com.cy.example.vo.IpAnalysisVo_Tb;
import com.cy.example.config.RabbitConfig;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.MailEntity;
import com.cy.example.util.HttpRequestUtil;
import com.cy.example.util.JsonUtil;
import com.cy.example.util.StringUtil;

@Slf4j
@Component
public class RabbitSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void sendLoginRecord(LoginRecordEntity loginRecord) {
		log.info("发送对象信息: " + loginRecord.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_LOGINRECORD, loginRecord);
	}

	public void sendMail(MailEntity mail) {
		log.info("发送对象信息: " + mail.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_MAIL, mail);
	}
	
}