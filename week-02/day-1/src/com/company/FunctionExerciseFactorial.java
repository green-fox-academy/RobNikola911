package com.company;

public class FunctionExerciseFactorial {
    public static void main(String[] args) {
        int givenNumber = 5;
        System.out.println(factorio(givenNumber));
    }

    public static int factorio(int num) {
        int result = num;
        for (int index = 1; index < num; index++) {
            result *= index;
        }
        return result;

    }
}

// - Create a function called `factorio`
//   that returns it's input's factorial