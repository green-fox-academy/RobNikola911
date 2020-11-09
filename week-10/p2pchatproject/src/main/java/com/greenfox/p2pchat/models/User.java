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
    private String login;
    private String password;
    private String username;

    public User(Long id, String login, String password, String username) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
