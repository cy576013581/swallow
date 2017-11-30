package com.cy.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.example.service.impl.MailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void testSimpleMail() throws Exception {
    	mailService.sendSimpleMail("pjchenyang@qq.com","test simple mail"," hello this is simple mail");
    }
    
    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("pjchenyang@qq.com","test simple mail",content);
    }
    
    @Test
    public void sendAttachmentsMail() {
        String filePath="c:\\application.txt";
        mailService.sendAttachmentsMail("pjchenyang@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
    
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";
        //添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
        mailService.sendInlineResourceMail("pjchenyang@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
}