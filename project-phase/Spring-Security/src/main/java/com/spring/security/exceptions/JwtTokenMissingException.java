package com.spring.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED) // code  401
public class JwtTokenMissingException extends RuntimeException {

    public JwtTokenMissingException() {
        super("No JWT token found in request headers");
    }
}

