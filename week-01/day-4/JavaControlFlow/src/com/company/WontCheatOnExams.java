package com.company;

import java.util.Scanner;

public class WontCheatOnExams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type in \"I wont cheat on the exam\" ");
        String userInput = scanner.nextLine();
        int a = 0;
        while (a < 100) {
            System.out.println(userInput);
            a++;
        }
    }
}

// Create a program that writes this line 100 times:
// "I won't cheat on the exam!"