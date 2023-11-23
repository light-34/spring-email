package com.sendemail.controller;

import com.sendemail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    MailSenderService service;

    @PostMapping ("/text")
    public void sendTextEmail() {
        service.sendEmail();
    }

    @PostMapping("/html")
    public void sendHtmlEmail() {
        service.sendHtmlEmail();
    }

    @PostMapping("/attach")
    public void sendAttachmentEmail() {
        service.sendHtmlEmail();
    }
}
