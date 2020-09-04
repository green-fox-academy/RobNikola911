package com.company;

import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows needed in the pattern ");
        int rows = scanner.nextInt();
        System.out.println("## Printing the pattern ##");
        int i, j;
        for (i = 0; i <= rows; i++) {
            for (j = 1; j <= rows - i; j++)
                System.out.print(" ");
            for (j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }

        for (i = rows - 1; i >= 1; i--) {
            for (j = 1; j <= rows - i; j++)
                System.out.print(" ");
            for (j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

// Write a program that reads a number from the standard input, then draws a
// diamond like this:
//
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
//
// The diamond should have as many lines as the number was