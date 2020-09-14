package com.company;

public class RecursionNumberAdder {
    public static void main(String[] args) {

        System.out.println(recursiveSum(5));
    }

    public static int recursiveSum(int iteration) {
        if (iteration == 1) {
            return 1;
        }
        return iteration + recursiveSum(iteration - 1);
    }
}