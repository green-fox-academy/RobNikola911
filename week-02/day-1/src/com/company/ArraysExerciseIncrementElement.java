package com.company;

public class ArraysExerciseIncrementElement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        numbers[2] = ++numbers[2];
        System.out.println("The third element is: " + numbers[2]);
    }
}
// - Create an array variable named `numbers`
//   with the following content: `[1, 2, 3, 4, 5]`
// - Increment the third element
// - Print the third element