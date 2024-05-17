package com.example;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class MyProjectBackendApplicationTests {

    @Resource
    JavaMailSender sender;
    @Resource
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("hello");
        message.setText("fuck you");
        message.setTo("123456@qq.com");
        message.setFrom("123456@qq.com");
        sender.send(message);
    }

    @Test
    void createExchangeTest() {
        DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("成功");
    }


}
