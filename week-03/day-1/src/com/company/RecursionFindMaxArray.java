package com.company;

public class RecursionFindMaxArray {
    public static void main(String[] args) {

        int[] arr = {10, 5, 7, 9, 15, 6, 11, 8, 12, 2, 3};
        int max = recursiveMax(arr, arr.length);
        System.out.println("Maximum element: " + max);
    }

    static int recursiveMax(int[] arr, int length) {
        if (length == 1)
            return arr[0];
        return Math.max(recursiveMax(arr, length - 1), arr[length - 1]);
    }

//    private static int max(int n1, int n2) {
//        return n1 > n2 ? n1 : n2;
//    }

}
//    Write a function that finds the largest element of an array using recursion.