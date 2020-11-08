package com.greenfox.trialexam.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class UrlModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String URL;
    private String alias;
    private int hitCount;
    private String secretCode;

    public UrlModel(String URL, String alias) {
        Random r = new Random();
        this.URL = URL;
        this.alias = alias;
        hitCount ++;
        secretCode = String.format("%04d", r.nextInt(1001));
    }
}
