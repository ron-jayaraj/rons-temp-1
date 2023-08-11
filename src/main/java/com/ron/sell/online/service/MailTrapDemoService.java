package com.ron.sell.online.service;

import com.ron.sell.online.domain.EmailRequest;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

@Service
public class MailTrapDemoService {


   @Resource
   private JavaMailSender javaMailSender;  //defined in our MailTrap config class

public void sendEmail(EmailRequest emailRequest)   {

    try{
    MimeMessage mimeMessage =javaMailSender.createMimeMessage();

    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true, null);
       
    mimeMessageHelper.setTo(emailRequest.getToAddress());
    mimeMessageHelper.setSubject("test subject");
    mimeMessageHelper.setFrom("no-reply-to-ron@rons.com", null);
    mimeMessageHelper.setText(emailRequest.getMessage(), false); //if you have prepared this as a html conent then set it as html as true

    javaMailSender.send(mimeMessage);
    }catch(Exception e){

        throw new RuntimeException(e.getMessage());
    }
     
    }
}
