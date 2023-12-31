package com.sendemail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

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

    public void sendEmailWithAttachment() {
        try {
            String from = "cezmi.aktepe@gmail.com";
            String to = "cezmi.aktepe04@gmail.com";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setSubject("Here's your e-book");
            helper.setFrom(from);
            helper.setTo(to);

            helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);

            FileSystemResource file = new FileSystemResource(new File("Hello.txt"));
            helper.addAttachment("Newtext.txt", file);

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmailInlineImage() {
        try {
            String from = "cezmi.aktepe@gmail.com";
            String to = "cezmi.aktepe04@gmail.com";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setSubject("Here's your picture");
            helper.setFrom(from);
            helper.setTo(to);

            String content = "<b>Dear ... </b>,<br><i>Please look at this nice picture:.</i>"
                    + "<br><img src='img.png'/><br><b>Best Regards</b>";
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File("img.png"));
            helper.addAttachment("resim.png", file);

            mailSender.send(message);

        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
