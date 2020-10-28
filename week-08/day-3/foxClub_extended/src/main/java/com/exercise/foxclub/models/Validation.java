package com.exercise.foxclub.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Validation {

    private boolean usernameOK;
    private boolean passwordOK;
    private String message;

    public Validation() {
        usernameOK = false;
        passwordOK = false;
        message = "";
    }
}
