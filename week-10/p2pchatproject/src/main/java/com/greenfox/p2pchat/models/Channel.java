package com.greenfox.p2pchat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Channel {

    private Integer id;
    private String name;
    private String description;
    private String admin;
    private String iconurl;
    private String secret;

}