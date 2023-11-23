package com.sendemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() {
        String from = "cezmi.aktepe@gmail.com";
        String to = "cezmi.aktepe04@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);

        message.setSubject("Test email");
        message.setText("Hello This is me ...");

        mailSender.send(message);
    }
}
