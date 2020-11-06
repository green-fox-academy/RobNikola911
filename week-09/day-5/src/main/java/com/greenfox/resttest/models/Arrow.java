package com.greenfox.resttest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Arrow {

     private Double distance;
     private Double time;
     private Double speed;
     private String error;

    public Arrow(Double distance, Double time) {
        if (distance == null || time == null){
            error = "Distance or time is null";
        } else {
            this.distance = distance;
            this.time = time;
            speed = distance/time;
        }
    }
}
