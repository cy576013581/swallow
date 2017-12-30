package com.cy.example.service;

import com.cy.example.entity.system.MailEntity;

public interface IMailService {

	public void sendSimpleMail(MailEntity mail);
	
	public void sendHtmlMail(MailEntity mail);
	
	public void sendAttachmentsMail(MailEntity mail);
	
	public void sendInlineResourceMail(MailEntity mail);

}
