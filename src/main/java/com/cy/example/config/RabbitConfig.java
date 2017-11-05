package com.cy.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	/*
	 * 登录记录队列
	 */
    @Bean
    public Queue Queue() {
        return new Queue("loginRecord");
    }

}