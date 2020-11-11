package com.greenfox.trialexam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) // code 403
public class  InvalidSecretCodeException extends RuntimeException{

    public InvalidSecretCodeException() {

        super("Invalid secret code");
    }
}