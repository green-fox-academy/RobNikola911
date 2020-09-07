package com.company;

import java.util.Arrays;

public class ArraysExerciseReverseOrder {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 6, 7};

        for (int indexElement = 0; indexElement < numbers.length / 2; indexElement++) {
            int temp = numbers[indexElement];
            numbers[indexElement] = numbers[numbers.length - indexElement - 1];
            numbers[numbers.length - indexElement - 1] = temp;
        }

        System.out.println("Array after reverse: " + Arrays.toString(numbers));
    }
}
// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Reverse the order of the elements in `numbers`
// - Print the elements of the reversed `numbers`