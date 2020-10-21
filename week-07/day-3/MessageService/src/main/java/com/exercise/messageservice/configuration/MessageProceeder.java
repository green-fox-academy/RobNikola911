package com.exercise.messageservice.configuration;

import com.exercise.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MessageProceeder {

    private MessageService messageService;

    @Autowired
    public MessageProceeder(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String email) {
        messageService.sendMessage(email, message);
    }
}
