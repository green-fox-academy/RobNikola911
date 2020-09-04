package com.company;

import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the distance in miles: ");
        double userInput = scanner.nextDouble();
        userInput *= 1.60934;
        System.out.println("The distance in km: " + userInput + "km");
        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it
    }
}