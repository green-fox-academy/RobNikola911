package com.company;

import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the first number please: ");
        int integer1 = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Type in the second number please: ");
        int integer2 = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Type in the third number please: ");
        int integer3 = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Type in the fourth number please: ");
        int integer4 = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Type in the fifth number please: ");
        int integer5 = scanner.nextInt();

        int sum = (integer1 + integer2 + integer3 + integer4 + integer5);
        int avr = (sum / 5);

        System.out.println("Summary of your numbers is: " + sum);
        System.out.println("The Average of your numbers is: " + avr);
    }
}
// Write a program that asks for 5 integers in a row,
// then it should print the sum and the average of these numbers like:
//
// Sum: 22, Average: 4.4