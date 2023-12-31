package com.sendemail.controller;

import com.sendemail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/img")
    public String sendImageEmail() {
        service.sendEmailInlineImage();
        return "Your image has been sent";
    }
}
