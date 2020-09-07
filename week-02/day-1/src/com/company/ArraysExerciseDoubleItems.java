package com.company;

public class ArraysExerciseDoubleItems {
    public static void main(String[] args) {
        int[] numList = {3, 4, 5, 6, 7};

        for (int elementIndex = 0; elementIndex < numList.length; elementIndex++) {
            numList[elementIndex] = numList[elementIndex] * 2;
            System.out.print(numList[elementIndex] + " ");
        }
    }
}
// - Create an array variable named `numList`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Double all the values in the array