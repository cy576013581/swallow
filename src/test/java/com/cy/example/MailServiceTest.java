package com.cy.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.example.entity.MailEntity;
import com.cy.example.service.impl.MailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void testSimpleMail() throws Exception {
    	MailEntity mail = new MailEntity();
    	mail.setTo("pjchenyang@qq.com");
    	mail.setSubject("test simple mail");
    	mail.setContent(" hello this is simple mail");
    	mailService.sendSimpleMail(mail);
    }
    
    @Test
    public void testHtmlMail() throws Exception {
    	String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
    	
        MailEntity mail = new MailEntity();
        mail.setTo("pjchenyang@qq.com");
    	mail.setSubject("test simple mail");
    	mail.setContent(" hello this is simple mail");
    	mail.setContent(content);
        mailService.sendHtmlMail(mail);
    }
    
    @Test
    public void sendAttachmentsMail() {
        String filePath="c:\\application.txt";
        MailEntity mail = new MailEntity();
        mail.setTo("pjchenyang@qq.com");
    	mail.setSubject("test simple mail");
    	mail.setContent(" hello this is simple mail");
    	mail.setFilePath(filePath);
        mailService.sendAttachmentsMail(mail);
    }
    
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";
        MailEntity mail = new MailEntity();
        mail.setTo("pjchenyang@qq.com");
    	mail.setSubject("test simple mail");
    	mail.setContent(" hello this is simple mail");
    	mail.setContent(content);
    	mail.setRscId(rscId);
    	mail.setRscPath(imgPath);
    	
        //添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
        mailService.sendInlineResourceMail(mail);
    }
}