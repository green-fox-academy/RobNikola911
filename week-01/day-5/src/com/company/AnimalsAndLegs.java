package com.company;

import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the number of chickens please: ");
        int inputNumber1 = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Type in the number of pigs please: ");
        int inputNumber2 = scanner.nextInt();
        int legs = (inputNumber1 * 2 + inputNumber2 * 4);
        System.out.println("All the animals have " + legs + " legs together.");

    }
}
// Write a program that asks for two integers
// The first represents the number of chickens the farmer has
// The second represents the number of pigs owned by the farmer
// It should print how many legs all the animals have