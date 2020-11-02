package com.greenfox.backendapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArrayResultType {
    int [] result;


    public ArrayResultType(int[] result) {
        this.result = result;
    }
}
