package com.company;

public class ArraysExerciseSumAll {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 6, 7};
        int sumOfNumbers = 0;

        for (int indexElements = 0; indexElements < numbers.length; indexElements++) {
            sumOfNumbers = numbers[indexElements] + sumOfNumbers;
        }
        System.out.print(sumOfNumbers);
    }
}

// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Print the sum of the elements in `numbers`