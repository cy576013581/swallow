package com.cy.example.supplement.rabbitmq.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cy.example.carrier.IpAnalysisCa;
import com.cy.example.config.RabbitConfig;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.MailEntity;
import com.cy.example.util.HttpRequestUtil;
import com.cy.example.util.JsonUtil;


@Component
public class RabbitSender {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${swallow.ip.analysis}")
	private String ipAnalysis;
	
	public void sendLoginRecord(LoginRecordEntity loginRecord) {
		String url = ipAnalysis +"?ip="+loginRecord.getC_loginIp();
		try {
			String addr = HttpRequestUtil.get(url);
			IpAnalysisCa ipAnalusis = JsonUtil.toBean(addr, IpAnalysisCa.class);
			if(0 == ipAnalusis.getCode()){
				loginRecord.setC_province(ipAnalusis.getData().getRegion());
			}else{
				loginRecord.setC_province("未知");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("解析IP出错！");
		}
		logger.info("发送对象信息: " + loginRecord.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_LOGINRECORD, loginRecord);
	}
	
	public void sendMail(MailEntity mail) {
		logger.info("发送对象信息: " + mail.toString());
		this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_MAIL, mail);
	}
	
}