package com.greenfox.resttest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Groot {
    private String recieved;
    private String translated;
    private String error;


    public Groot (String message){
        if (message == null || message.isEmpty()){
            error = "I am Groot!";
        }
        else {
            recieved = message;
            translated = "I am Groot!";
        }
    }
}
