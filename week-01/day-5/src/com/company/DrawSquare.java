package com.company;

import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int inputNumber = scanner.nextInt();
        int i, j;
        for (i = 1; i <= inputNumber; i++) {
            for (j = 1; j <= inputNumber; j++) {
                if (i == 1 || i == inputNumber ||
                        j == 1 || j == inputNumber)
                    System.out.print("%");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
