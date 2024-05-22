package ru.letton.practice_16.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender emailSender;

    @Async
    public void sendEmail(String recipient, String subject, String body) {
        log.info("Preparing to send email to {}: Subject: {}, Body: {}", recipient, subject, body);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipient);
            message.setSubject(subject);
            message.setText(body);
            emailSender.send(message);
            log.info("Email sent to {}", recipient);
        } catch (Exception e) {
            log.error("Error occurred while sending email to {}", recipient, e);
        }
    }
}