package com.spring.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException {

    @ResponseStatus(HttpStatus.NOT_FOUND) // code  404
    public static class LinkNotFoundException extends RuntimeException {

        public LinkNotFoundException(){
            super("Movie not found!");
        }
    }
}
