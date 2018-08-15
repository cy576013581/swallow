package com.cy.example.service.impl;

import com.cy.example.entity.system.MailEntity;
import com.cy.example.service.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class MailService implements IMailService{

    @Autowired
    private JavaMailSender mailSender;

    @Value("${swallow.fromMail.addr}")
    private String from;

    /*
     * (non-Javadoc)
     * @see com.cy.example.service.IMailService#sendSimpleMail(java.lang.String, java.lang.String, java.lang.String)
     */
    public void sendSimpleMail(MailEntity mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        try {
            mailSender.send(message);
            log.info("发送给"+mail.getTo()+"邮件已经发送。");
        } catch (Exception e) {
            log.error("发送纯文本邮件时发生异常！", e);
        }
    }
    
    /*
     * 发送html格式邮件(non-Javadoc)
     * @see com.cy.example.service.IMailService#sendHtmlMail(java.lang.String, java.lang.String, java.lang.String)
     */
    public void sendHtmlMail(MailEntity mail) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), true);

            mailSender.send(message);
            log.info("发送给"+mail.getTo()+"邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常！", e);
        }
    }
    
    /*
     * 发送带附件的邮件
     * 添加多个附件可以使用多条 helper.addAttachment(fileName, file)
     */
    public void sendAttachmentsMail(MailEntity mail){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), true);

            FileSystemResource file = new FileSystemResource(new File(mail.getFilePath()));
            String fileName = mail.getFilePath().substring(mail.getFilePath().lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            log.info("发送给"+mail.getTo()+"邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常！", e);
        }
    }
    
    /*
     * 发送带静态资源的邮件
     */
    
    public void sendInlineResourceMail(MailEntity mail){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), true);

            FileSystemResource res = new FileSystemResource(new File(mail.getRscPath()));
            helper.addInline(mail.getRscId(), res);

            mailSender.send(message);
            log.info("发送给"+mail.getTo()+"邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
