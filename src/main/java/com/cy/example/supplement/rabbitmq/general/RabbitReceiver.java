package com.cy.example.supplement.rabbitmq.general;

import com.alibaba.fastjson.JSON;
import com.cy.example.util.StringUtil;
import com.cy.example.vo.IpAnalysisVo_Sina;
import com.cy.example.vo.IpAnalysisVo_Tb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.MailEntity;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IMailService;
import com.cy.example.util.HttpUtil;

@Slf4j
@Configuration
public class RabbitReceiver {


	@Autowired
	private ILoginRecordService loginRecordService;

	@Autowired
	private IMailService mailService;

	@Value("${swallow.ip.analysis}")
	private String ipAnalysis;

	@RabbitListener(queues = "loginRecord")
    public void insertLoginRecord(LoginRecordEntity loginRecord) {
		String tbUrl = ipAnalysis.split(",")[0] + loginRecord.getC_loginIp();
		try {
			String addr = HttpUtil.get(tbUrl);
			IpAnalysisVo_Tb ipAnalusisTb = JSON.parseObject(addr, IpAnalysisVo_Tb.class);
			if(0 == ipAnalusisTb.getCode()){
				if(StringUtil.IsEqual("XX", ipAnalusisTb.getData().getRegion())){
					loginRecord.setC_province(ipAnalusisTb.getData().getCity())
							.setC_city(ipAnalusisTb.getData().getCity());
				}else{
					loginRecord.setC_province(ipAnalusisTb.getData().getRegion())
							.setC_city(ipAnalusisTb.getData().getCity());
				}

			}else{
				String sinaUrl = ipAnalysis.split(",")[1] + loginRecord.getC_loginIp();
				addr = HttpUtil.get(sinaUrl);
				IpAnalysisVo_Sina ipAnalusisSina = JSON.parseObject(addr, IpAnalysisVo_Sina.class);
				if(1 == ipAnalusisSina.getRet()){
					loginRecord.setC_province(ipAnalusisSina.getProvince())
						.setC_city(ipAnalusisSina.getCity());
				}else{
					loginRecord.setC_province("未知")
					 		.setC_city("未知");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("解析IP出错！");
			loginRecord.setC_province("未知")
					.setC_city("未知");
		}
		log.info("接收到object : " + loginRecord);
		loginRecordService.insert(loginRecord);
    }

	@RabbitListener(queues = "mail")
    public void process(MailEntity mail) {
		log.info("接收到object : " + mail);
		mailService.sendSimpleMail(mail);
    }

}
