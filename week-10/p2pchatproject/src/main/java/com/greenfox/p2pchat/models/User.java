package com.greenfox.p2pchat.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class User {

    @JsonProperty(value = "userid")
    private Long id;
    private String username;
    private String avatarurl;

    public User(Long id, String username, String avatarurl) {
        this.id = id;
        this.username = username;
        this.avatarurl = avatarurl;
    }
}
