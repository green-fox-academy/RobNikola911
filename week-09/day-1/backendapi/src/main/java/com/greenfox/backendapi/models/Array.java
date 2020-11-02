package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Array {
    private String what;
    private int[] numbers;
    private int result;

    public Array(String what, int[] numbers, int result) {
        this.what = what;
        this.numbers = numbers;
        this.result = result;
    }

    public void sumArray(Array array) {
        if (what.equals("sum")) {
            result = IntStream.of(numbers).sum();
            what = null;
            numbers = null;
        }
    }

    public void multiplyArray(Array array) {
        if (what.equals("multiply")) {
            result = IntStream.of(numbers).reduce(1, (a, b) -> a * b);
            what = null;
            numbers = null;
        }
    }

    public Object doubleArray(Array array) {
        if (what.equals("double")) {
            int[] d = IntStream.of(numbers).flatMap(x -> IntStream.of(x, x)).toArray();
            return new ArrayResultType(d);
        } else
            return new Error("Please provide what to do with the numbers!");
    }
}
