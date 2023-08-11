package com.ron.sell.online.controller;

import com.ron.sell.online.domain.EmailRequest;
import com.ron.sell.online.service.MailTrapDemoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/mail-trap-demo", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mail Trap Demo endpoint")
public class MailTrapDemoController {

    // http://localhost:8080/sell-online-api/mail-trap-demo/SomeText(the SomeText can be anyting can be anything like
    // OR use swagger
    // http://localhost:8080/sell-online-api/swagger-ui/index.html?configUrl=/sell-online-api/v3/api-docs/swagger-config#/

    @Resource
    MailTrapDemoService mailTrapDemoService;

    @PostMapping 
    @Operation(summary = "Demo sending email to mail trap...helpful in dev envs...properteis file in prod will have real smtp server host whereas the dev env will have mail trap host")
public RonsResponseData<String> sendEmailDemo(@RequestBody final EmailRequest emailRequest) {
         mailTrapDemoService.sendEmail(emailRequest);
        return new RonsResponseData<>("success- go to https://mailtrap.io/inboxes to see the email login heyron123@gamil.com passwrod is Mailtrap821#");
        
    }
    }

