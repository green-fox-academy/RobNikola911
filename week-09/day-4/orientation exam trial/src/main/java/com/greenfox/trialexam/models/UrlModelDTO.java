package com.greenfox.trialexam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UrlModelDTO {

    private String secretCode;

    public UrlModelDTO(String secretCode) {
        this.secretCode = secretCode;
    }
}
