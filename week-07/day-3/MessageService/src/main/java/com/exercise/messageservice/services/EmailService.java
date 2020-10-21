package com.exercise.messageservice.services;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String email, String emailContent) {
        System.out.println("Email Sent to " + email + " with Message=" + emailContent);
    }
}
