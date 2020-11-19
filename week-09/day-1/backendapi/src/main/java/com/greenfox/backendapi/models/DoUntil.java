package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoUntil {
    private Integer until;
    private int result;

    public void calculate(String action) {
        if (action.equals("sum")){
            result = sum(until);
            until = null;
        } else if(action.equals("factor")) {
            result = factor(until);
            until = null;
        }
    }

    public int sum(int until) {
        int sum = 0;
        for (int j = 1; j <= until; j++) {
            sum += j;
        }
        return sum;
    }
    public int factor (int until) {
        int fact = 1;
        for (int i = 1; i <= until; i++) {
            fact = fact*i;
        }
        return fact;
    }
}
