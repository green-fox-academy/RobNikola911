package com.company;

import java.util.ArrayList;

public class RecursiveSumDigit {
    public static void main(String[] args) {
        int number = 3652;
        int result = sumDigits(number);
        System.out.println("Sum of digits in " + number + " is " + result);
    }

    private static int sumDigits(int iteration) {
        if (iteration == 0)
            return 0;
        return (iteration % 10 + sumDigits(iteration / 10));
    }

}
