package com.greenfox.trialexam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // code  404
public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(){
        super("Link not found!");
    }
}