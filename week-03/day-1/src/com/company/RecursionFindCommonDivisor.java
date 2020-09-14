package com.company;

public class RecursionFindCommonDivisor {
    public static void main(String[] args) {

        int n1 = 363, n2 = 33;
        int greatestCommonDivisor = recursiveGCD(n1, n2);
        System.out.printf("G.C.D of %d and %d is %d.", n1, n2, greatestCommonDivisor);

    }

    public static int recursiveGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return recursiveGCD(n2, n1 % n2);
    }

}

/*        int num1 = 330, num2 = 33;

        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        System.out.printf("GCD of given numbers is: %d", num2);*/


//    Find the greatest common divisor of two numbers using recursion.