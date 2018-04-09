package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;
import lombok.Data;

@TableName("s_mail")
@SuppressWarnings("serial")
@Data
public class MailEntity extends SuperEntity<MailEntity>{

	private String to;
	
	private String subject;
	
	private String content;
	
	private String filePath;
	
	private String rscPath;
	
	private String rscId;
}
