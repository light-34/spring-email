package com.sendemail.controller;

import com.sendemail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    MailSenderService service;

    @GetMapping("/text")
    public void sendTextEmail() {
        service.sendEmail();
    }

    @GetMapping("/html")
    public void sendHtmlEmail() {
        service.sendHtmlEmail();
    }

    @GetMapping("/attach")
    public void sendAttachmentEmail() {
        service.sendEmailWithAttachment();
    }
}
