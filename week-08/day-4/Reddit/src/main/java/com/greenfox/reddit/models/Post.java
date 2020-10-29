package com.greenfox.reddit.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int likeCounter;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();


    public Post(String title, String url) {
        this.title = title;
        this.url = url;
        this.likeCounter = 0;
    }
}
