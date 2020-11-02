package com.greenfox.backendapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    String welcome_message;

    public Message(String welcome_message) {
        this.welcome_message = welcome_message;
    }
}