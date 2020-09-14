package com.company;

public class RecursionMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(maxSum(arr, arr.length));
    }

    public static int maxSum(int[] arr, int length) {
        if (length == 1)
            return arr[0];
        return Math.max(maxSum(arr, length - 1), arr[length - 1]);
    }
}
//    Create a function called maxSum which expects an array of five integers as an input parameter
//    and returns the maximum values that can be calculated by summing exactly four of the five integers.