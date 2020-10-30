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
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToMany
    List<Post> posts;

    @OneToMany
    List<Post> voted;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addToVoted (Post post) {
        voted.add(post);
    }
}
