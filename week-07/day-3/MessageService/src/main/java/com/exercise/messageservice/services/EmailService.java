package com.exercise.messageservice.services;

public class EmailService implements MessageService {


    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
