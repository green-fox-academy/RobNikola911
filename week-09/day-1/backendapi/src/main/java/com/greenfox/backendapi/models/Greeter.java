package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Greeter {

    private String name;
    private String title;

    public Greeter() {
    }

    public Greeter(String name, String title) {
        this.name = name;
        this.title =  title;
    }
}
