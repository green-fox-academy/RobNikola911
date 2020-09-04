package com.company;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your number: ");
        int userInput = scanner.nextInt();
        if (userInput % 2 == 0) {
            System.out.println(userInput + " is an EVEN number!");
        } else {
            System.out.println(userInput + " is an Odd number!");
        }
    }
}

// Write a program that reads a number from the standard input,
// Then prints "Odd" if the number is odd, or "Even" if it is even.