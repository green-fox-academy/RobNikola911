package com.greenfox.p2pchat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Channel {

    private Integer id;
    private String name;
    private String description;
    private User admin;
    private String iconurl;
    private String secret;

}