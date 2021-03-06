package com.greenfox.p2pchat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class Message {

    private String content;
    private User author;
    private Date created;
    private Channel channel;


    public Message(String content, User author, Date created) {
        this.content = content;
        this.author = author;
        this.created = created;
    }
}