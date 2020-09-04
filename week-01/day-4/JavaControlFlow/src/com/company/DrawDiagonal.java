package com.company;

import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int inputNumber = scanner.nextInt();
        int i, j;
        for (i = 1; i <= inputNumber; i++) {
            for (j = 1; j <= inputNumber; j++) {
                if (i == 1 || i == inputNumber ||
                        j == 1 || j == inputNumber || j == i)
                    System.out.print("%");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
//(inputNumber - i + 1) - for other way around


// Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was