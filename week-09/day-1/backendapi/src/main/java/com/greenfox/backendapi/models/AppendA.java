package com.greenfox.backendapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppendA {
    private String appended;

    public AppendA(String appended) {
        this.appended = appended.concat("a");
    }
}
