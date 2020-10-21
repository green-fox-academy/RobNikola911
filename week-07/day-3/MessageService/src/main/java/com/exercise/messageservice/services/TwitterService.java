package com.exercise.messageservice.services;

import org.springframework.stereotype.Service;

@Service
public class TwitterService implements MessageService{

    @Override
    public void sendMessage(String email, String emailContent) {
        System.out.println("Twitter Sent to " + email + " with Message=" + emailContent);
    }
}
