package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doubling {
    private Integer received;
    private Integer result;

    public Doubling(Integer received) {
        this.received = received;
        this.result = received * 2;
    }

    public Doubling() {
    }
}