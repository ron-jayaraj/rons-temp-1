package com.ron.sell.online.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailTrapConfig {

    //https://mailtrap.io/inboxes/2352929/messages   heyron123@gmail.com/Mailtrap821#
    @Bean
    public JavaMailSender javaMailSender(){
       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
       javaMailSender.setHost("sandbox.smtp.mailtrap.io");
       javaMailSender.setPort(25); //better use the other port they gave port 587

       javaMailSender.setUsername("7bf85289578109");
       javaMailSender.setPassword("299d2920522031");

    return javaMailSender;


    }
    
}
