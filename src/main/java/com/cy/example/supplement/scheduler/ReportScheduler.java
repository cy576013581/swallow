package com.cy.example.supplement.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.cy.example.entity.MailEntity;
import com.cy.example.supplement.rabbitmq.general.RabbitSender;
import com.cy.example.util.DateUtil;

public class ReportScheduler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RabbitSender rabbitSender;

	//@Scheduled(fixedRate = 6000)
    @Scheduled(cron="0 0 0 * * ?")   //每天24点执行
    public void reportCurrentTime() {
    	String content = "";
    	MailEntity mail = new MailEntity();
		mail.setTo("pjchenyang@qq.com");
    	mail.setContent(content);
    	rabbitSender.sendMail(mail);
    	logger.info("发送系统状态邮件,to" + DateUtil.getNow());
    }
}
