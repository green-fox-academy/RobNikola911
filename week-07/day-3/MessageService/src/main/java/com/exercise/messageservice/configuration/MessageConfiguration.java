package com.exercise.messageservice.configuration;

import com.exercise.messageservice.services.MessageService;
import com.exercise.messageservice.services.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    @Bean
    public MessageService messageService(){
        return new TwitterService();
    }
}
