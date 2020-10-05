import java.util.Arrays;

public class OddNumbers {
    public static void main(String[] args) {

        int[][] example = new int[][]{
                {1, 2, 3, 4}, // 0
                {4, 5, 6, 12}, // 1
                {7, 8, 7, 1}, // 2
                {3, 2, 9, 1}};  // 3
            // 0   1  2   3
        System.out.println(example.length);
        sumDivisibleBy5And7(example);
        System.out.println("There are " + sumOddsDiv3(example)[0] +
                " numbers and the sum is " + sumOddsDiv3(example)[1]);
    }

    public static int oddNumbers(int[][] matrix) {
        int sumOddNumbers = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] % 2 == 1) {
                    sumOddNumbers += matrix[row][col];
                }
            }

        }

        return sumOddNumbers;
    }

    public static int[] sumOddsDiv3(int[][] matrix) {
        int[] matrixToReturn = new int[2];
        int sumOdds = 0;
        int counter = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] % 3 == 0 && matrix[row][col] != 0) {
                    sumOdds += matrix[row][col];
                    counter++;
                }
            }
        }
        matrixToReturn[0] = counter;
        matrixToReturn[1] = sumOdds;
        return matrixToReturn;
    }

    public static void sumDivisibleBy5And7(int[][] matrix) {
        int sum57 = 0;
        int counter = 0;


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] % 5 == 0 || matrix[row][col] % 7 == 0) {
                    sum57 += matrix[row][col];
                    counter++;
                }
            }
        }
        System.out.println("The sum is " + sum57 + " counter " + counter);
    }
}
/*
    Writes out the sum of all numbers that are divisible by 3 and odd like this:
        There are X odd numbers that are divisible by 3 and their sum is Y.

        AND

        Writes out the sum of all number that divisible either by 5 or 7 like this:
        There are XX numbers that are divisible by 5 or 7 and there sum is YY.*/
