package com.company;

public class FunctionsHardSubInt {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 11, 34, 52, 61};
        int findableInt = 1;
        getIndexes(arr, findableInt);
    }

    public static void getIndexes(int[] arr, int findable) {
        String findableStr = Integer.toString(findable);
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
//            61 => "61"
            String tmp = Integer.toString(arr[i]);
            if (tmp.contains(findableStr)) {
                System.out.print(i);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print(" ]");
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
