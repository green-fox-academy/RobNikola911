package com.greenfox.reddit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String username;
    private String password;
    private boolean voted;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        voted = false;
    }

    public User() {
    }
}
