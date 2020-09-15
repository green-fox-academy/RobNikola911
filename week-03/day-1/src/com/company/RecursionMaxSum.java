package com.company;

public class RecursionMaxSum {
    public static void main(String[] args) {
        int[] arr = {11, 2, 31, 4, 51};

        int sum = 0;

        int min = min(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min)
                continue;

            sum += arr[i];
        }

        System.out.printf("The sum of the maximum 4 items: %d\n", sum);
    }

    public static int min(int[] arr, int length) {
        if (length == 1)
            return arr[0];

        return Math.min(min(arr, length - 1), arr[length - 1]);
    }
}
    // Function to remove the element
//    public static int[] removeTheElement(int[] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
//        if (arr == null || index < 0 || index >= arr.length) {
//
//            return arr;
//        }

        // Create another array of size one less
//        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
//        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
//            if (i == index) {
//                continue;
//            }

            // if the index is not
            // the removal element index
//            anotherArray[k++] = arr[i];
//        }

        // return the resultant array
//        return anotherArray;



// Create a function called maxSum which expects an array of five integers as an
// input parameter
// and returns the maximum values that can be calculated by summing exactly four
// of the five integers.