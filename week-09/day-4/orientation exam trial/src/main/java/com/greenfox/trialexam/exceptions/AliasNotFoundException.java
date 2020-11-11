package com.greenfox.trialexam.exceptions;

public class AliasNotFoundException extends RuntimeException{

    public AliasNotFoundException(){
        super("Alias not find!!");
    }
}