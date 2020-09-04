package com.company;

import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a number: ");
        int inputNumber = scanner.nextInt();

        for (int i = 1; i <= inputNumber; i++) {
            for (int j = inputNumber; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
// Write a program that reads a number from the standard input, then draws a
// pyramid like this:
//
//
//    *
//   ***
//  *****
// *******
//
// The pyramid should have as many lines as the number was