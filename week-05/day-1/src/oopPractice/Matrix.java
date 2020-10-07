package oopPractice;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 2, 4}, // 0
                          {4, 5, 6, 2,}, // 1
                          {2, 4, 5, 4, 6,}, // 2
                          {1, 2, 4, 3}};  // 3
        //                 0  1  2   3
        System.out.println(symmetric(matrix));
        paralell(matrix);  // sum all the elements of 0 and 2 col
        lines(matrix);
        paralellDifflen(matrix);
    }

    public static boolean symmetric(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] != matrix[matrix.length - 1 - col][matrix.length - 1 - row]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void paralell(int[][] matrix) {
        int rowsSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            rowsSum += matrix[row][0] + matrix[row][2];

        }
//        for (int[] ints : matrix) {
//            rowsSum += ints[0] + ints[2];
//        }
        System.out.println("The sum of these rows is " + rowsSum);
    }

    public static void lines(int[][] matrix) {
        int[] rows = {0, 2};
        int sumAll = 0;
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i];
            int colsSum = 0;
            for (int j = 0; j < matrix[row].length; j++) {
                colsSum += matrix[row][j];
                sumAll += matrix[row][j];
            }
            System.out.printf("sum of %dth row: %d\n", i + 1, colsSum);
        }
        System.out.println("The sum of the first and third line is: " + sumAll);
    }

    public static void paralellDifflen(int[][] matrix) {
        int sum = 0;
        int maxLength = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length > maxLength) {
                maxLength = matrix[row].length;
            }
        }
        for (int col = 0; col < maxLength; col += 2) {
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (col <= matrix[row].length - 1) {
                    sum += matrix[row][col];
                    colSum += matrix[row][col];
                }
            }
            System.out.println("The sum of the elements in the " + (col + 1) + ". line is " + colSum);
        }
        System.out.println("The sum of the second, third, forth line is: " + sum);
    }
}