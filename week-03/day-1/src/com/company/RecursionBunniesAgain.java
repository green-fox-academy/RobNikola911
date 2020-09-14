package com.company;

public class RecursionBunniesAgain {
    public static void main(String[] args) {
        int bunnies = 7;
        System.out.println(recursiveEars(bunnies));
    }

    public static int recursiveEars(int bunnies) {
        int evenLine = 3;
        int oddLine = 2;
        if (bunnies != 1) {
            if (bunnies % 2 == 0) {
                return recursiveEars(bunnies - 1) + evenLine;
            } else {
                return recursiveEars(bunnies - 1) + oddLine;
            }
        }
        return 2;
    }
}

//    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..)
//    have the normal 2 ears. The even bunnies (2, 4, ..)
//    we'll say have 3 ears, because they each have a raised foot.
//    Recursively return the number of "ears" in the bunny line 1, 2, ... n
//    (without loops or multiplication).