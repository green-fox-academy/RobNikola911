package com.company;

import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        int firstNum = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Second number: ");
        int secondNum = scanner.nextInt();
        if (firstNum > secondNum) {
            System.out.println("The bigger number is: " + firstNum);
        } else {
            System.out.println("The bigger number is: " + secondNum);
        }

    }
}
// Write a program that asks for two numbers and prints the bigger one