package com.cy.example.supplement.rabbitmq.general;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cy.example.entity.LoginRecordEntity;

@Component
@RabbitListener(queues = "loginRecord")
public class RabbitReceiver {

    @RabbitHandler
    public void process(LoginRecordEntity loginRecordEntity) {
        System.out.println("Receiver object : " + loginRecordEntity);
    }

}
