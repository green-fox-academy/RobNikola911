package com.company;

import java.util.Scanner;

public class ExceptionDivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add your number to divide 10: ");
        int divisor = scanner.nextInt();
//        System.out.println("The result is: " + func(divisor));
        try {
            System.out.println("The result is: " + func(divisor));
        } catch (IllegalArgumentException e) {
            System.out.println("fail");
        }
    }

    private static int func(int divisor) {
        int result = 0;
        try {
            result = 10 / divisor;

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(e);
        }
        return result;
    }
}
// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0