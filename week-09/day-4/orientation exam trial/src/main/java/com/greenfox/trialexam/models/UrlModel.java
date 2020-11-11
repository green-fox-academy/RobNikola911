package com.greenfox.trialexam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;


@Getter
@Setter
@Entity
public class UrlModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String alias;
    private int hitCount;
    @JsonIgnore
    private String secretCode;

    public UrlModel(String url, String alias) {
        this.url = url;
        this.alias = alias;
    }

    public UrlModel() {

    }
}
