package com.company;

public class ArraysExerciseMatrix {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[4][4];

        for (int rows = 0; rows < twoDimensionalArray.length; rows++) {
            for (int col = 0; col < twoDimensionalArray.length; col++) {
                if (rows == col) {
                    twoDimensionalArray[rows][col] = 1;
                }
                System.out.print(twoDimensionalArray[rows][col] + " ");
            }
            System.out.println("");
        }
    }
}

// - Create (dynamically) a two dimensional array
//   with the following matrix. Use a loop!
//
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1
//
// - Print this two dimensional array to the output