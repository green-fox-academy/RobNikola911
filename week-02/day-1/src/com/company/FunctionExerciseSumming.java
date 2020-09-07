package com.company;

public class FunctionExerciseSumming {
    public static void main(String[] args) {
    int givenNumber = 8;
        System.out.println(sum(givenNumber));
    }
    public static int sum(int num) {
        int result = num;
        for (int index = 0; index < num; index++) {
            result += index;
        }
        return result;
    }
}

// Create the usual class wrapper and main method on your own.
// Write a function called `sum` that returns the sum of numbers from zero to the given parameter