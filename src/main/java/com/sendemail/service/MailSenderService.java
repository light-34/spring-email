package com.sendemail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

    public void sendHtmlEmail() {
        String from = "cezmi.aktepe@gmail.com";
        String to = "cezmi.aktepe04@gmail.com";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setSubject("This is an Html email");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText("<h1> This is an html email demo </h1>", true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
