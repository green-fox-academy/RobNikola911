package com.company;

public class RecursionPower {
    public static void main(String[] args) {
        int base = 2, powerOfBase = 10;
        int result = power(base, powerOfBase);

        System.out.printf("%d^%d = %d", base, powerOfBase, result);
    }

    private static int power(int base, int powerOfBase) {
        if (powerOfBase != 0)
            return (base * power(base, powerOfBase - 1));
        else
            return 1;
    }
}
