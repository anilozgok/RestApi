package org.bicell.rest.api.message;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Properties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class email implements Message{

    @Autowired
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


    @Override
    public void sendMessage(String toEmail, String subject, String body) {
        sendEmail(toEmail, subject, body);
    }

    private void sendEmail(String toEmail, String subject, String body){
        mailSender.setHost("");
        mailSender.setPort(0);
        mailSender.setUsername("");
        mailSender.setPassword("");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
