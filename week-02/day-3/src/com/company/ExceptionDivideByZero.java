package com.company;

import java.util.Scanner;

public class ExceptionDivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add your number to divide 10: ");
        int divisor = scanner.nextInt();


        try {
            int result = 10 / divisor;
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("fail");
        }
    }
}
// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0