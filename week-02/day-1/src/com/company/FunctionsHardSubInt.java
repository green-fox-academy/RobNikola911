package com.company;

import java.util.Arrays;

public class FunctionsHardSubInt {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 52, 6};
        int givenNumber = 6;
        System.out.println(Arrays.toString(subInt(givenNumber, numbers)));
    }

    public static int subInt(int[] arr, int value) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }
}

//  Create a function that takes a number and an array of integers as a parameter
//  Returns the indices of the integers in the array of which the first number is a part of
//  Or returns an empty array if the number is not part of any of the integers in the array

//  Example:
//        System.out.println(Arrays.toString(subInt(1, new int[] {1, 11, 34, 52, 61})));
//  should print: `[0, 1, 4]`
//        System.out.println(Arrays.toString(subInt(9, new int[] {1, 11, 34, 52, 61})));
//  should print: '[]'

// Note: We are using Arrays.toString() function as a way to print
// array returned from subInt(). You could just as well iterate over array to print it.
