package oopPractice;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {  {3,4,2,4},
                            {4,5,6,2},
                            {2,4,5,4},
                            {1,2,4,3}};
        System.out.println(symmetric(matrix));
    }

    public static boolean symmetric(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] != matrix[matrix.length-1-col][matrix.length-1-row]){
                    return false;
                }
            }
        }
        return true;
    }
}
