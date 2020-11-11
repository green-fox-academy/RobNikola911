package com.greenfox.trialexam.exceptions;

public class ExistingLinkException extends RuntimeException {

    public ExistingLinkException(){
        super("This link already exist!!");
    }
}