package com.ron.sell.online.controller;
// src/main/java/com/auth0/example/web/APIController.java

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ron.sell.online.domain.Message;

@RestController
@RequestMapping(path = "api-user", produces = MediaType.APPLICATION_JSON_VALUE)
// For simplicity of this sample, allow all origins. Real applications should configure CORS for their use case.
@CrossOrigin(origins = "*")
public class LoginController {

    // READ RonsNotes under resources folder
  // test url :-> curl --insecure -X POST "https://localhost:8443/sell-online-api/api-user/login" -H "accept: application/json"
    @PostMapping(value = "/login")
    public Message postLogIn() {
        return new Message("Post method of LOGIN CONTROLLER ");
    }

    @GetMapping(value = "/login")
    public Message getLogIn() {
        return new Message("Get method of LOGIN CONTROLLER ");
    }
    

}

