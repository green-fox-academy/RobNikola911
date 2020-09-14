package com.company;

public class RecursionStringCharChange {
    public static void main(String[] args) {
        String sentence = "Whx not to swap x to y?";
        System.out.println(recursiveChangeX(sentence));
    }

    private static String recursiveChangeX(String xToy) {
        if (xToy.length() == 0)
            return xToy;
        else if (xToy.charAt(0) == 'x') {
            xToy = 'y' + xToy.substring(1);
        }
        return xToy.charAt(0) + recursiveChangeX(xToy.substring(1));

    }
}
//    Given a string, compute recursively (no loops) a
//    new string where all the lowercase 'x' chars have been changed to 'y' chars.