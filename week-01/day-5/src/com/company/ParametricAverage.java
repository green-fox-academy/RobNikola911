package com.company;

import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in how many numbers you want to compare please: ");
        int times = scanner.nextInt();
        int sum = 0;
        int avr = 0;
        int inputNumbers = 0;
        System.out.println("Your numbers: ");
        for (int numberOfTimes = 0; numberOfTimes < times; numberOfTimes++) {
            if (numberOfTimes < times) {
                inputNumbers = scanner.nextInt();
                sum = sum + inputNumbers;
                avr = sum / times;
            }
            System.out.println(sum);
            System.out.println(avr);
        }
    }
}

// Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4