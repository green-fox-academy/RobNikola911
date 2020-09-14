package com.company;

public class RecursionBunnies {
    public static void main(String[] args) {
        int bunnies = 8;
        System.out.println(recursiveEars(bunnies));
//        System.out.println(recursiveEars1(bunnies));
    }

    public static int recursiveEars(int bunnies) {
        if (bunnies == 1) {
            return 2;
        }
        return recursiveEars(bunnies - 1) + 2;
    }
}
//    public static int recursiveEars1(int bunnies) {
//        if (bunnies != 0) {
//            return 2 + recursiveEars( bunnies - 1);
//        }
//        return 0;
//    }
//}
//    We have a number of bunnies and each bunny has two big floppy ears.
//    We want to compute the total number of ears
//    across all the bunnies recursively (without loops or multiplication).