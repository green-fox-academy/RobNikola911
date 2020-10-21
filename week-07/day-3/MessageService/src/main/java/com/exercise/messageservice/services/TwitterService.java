package com.exercise.messageservice.services;

import org.springframework.stereotype.Service;

@Service
public class TwitterService implements MessageService{

    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
