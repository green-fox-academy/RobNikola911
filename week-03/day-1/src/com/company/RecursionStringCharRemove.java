package com.company;

public class RecursionStringCharRemove {
    public static void main(String[] args) {
        String sentence = "Why not to remove x all x?";
        System.out.println(recursiveRemoveX(sentence));
    }

    private static String recursiveRemoveX(String xRem) {
        if (xRem.length() == 0)
            return xRem;
        else if (xRem.charAt(0) == 'x') {
            xRem = "" + xRem.substring(1);
        }
        return xRem.charAt(0) + recursiveRemoveX(xRem.substring(1));

    }
}
//    Given a string, compute recursively a new string where all the 'x' chars have been removed.