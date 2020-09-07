package com.company;

public class ArraysExerciseSwapElements {
    public static void main(String[] args) {
        String[] orders = {"first", "second", "third"};
        String temp = orders[0];
        orders[0] = orders[2];
        orders[2] = temp;

        for (int elementIndex = 0; elementIndex < orders.length; elementIndex++) {
            System.out.print(orders[elementIndex] + " ");
        }
    }
}
// - Create an array variable named `orders`
//   with the following content: `["first", "second", "third"]`
// - Swap the first and the third element of `orders`