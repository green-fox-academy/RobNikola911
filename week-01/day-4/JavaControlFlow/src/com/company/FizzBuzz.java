package com.company;

public class FizzBuzz {
    public static void main(String[] args) {
        String fizz = "Fizz";
        String buzz = "Buzz";

        for (int num = 1; num < 100; num++) {
            if (((num % 3) == 0) && ((num % 5) == 0)) {
                System.out.println(fizz + buzz);
            } else if ((num % 3) == 0) {
                System.out.println(fizz);
            } else if ((num % 5) == 0) {
                System.out.println(buzz);
            } else
                System.out.println(num);
        }
    }
}

// Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.