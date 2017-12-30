package com.cy.example.entity.system;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cy.example.entity.SuperEntity;

@TableName("s_mail")
@SuppressWarnings("serial")
public class MailEntity extends SuperEntity<MailEntity>{

	private String to;
	
	private String subject;
	
	private String content;
	
	private String filePath;
	
	private String rscPath;
	
	private String rscId;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getRscPath() {
		return rscPath;
	}

	public void setRscPath(String rscPath) {
		this.rscPath = rscPath;
	}

	public String getRscId() {
		return rscId;
	}

	public void setRscId(String rscId) {
		this.rscId = rscId;
	}
	

}
