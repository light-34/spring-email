package com.sendemail.controller;

import com.sendemail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    MailSenderService service;

    @GetMapping("/")
    public void sendMessage() {
        service.sendEmail();
    }
}
