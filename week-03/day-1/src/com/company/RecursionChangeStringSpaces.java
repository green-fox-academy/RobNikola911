package com.company;

public class RecursionChangeStringSpaces {
    public static void main(String[] args) {
        String sentence = " Why not to remove spaces?";
        System.out.println(recursiveRemoveSpaces(sentence));
    }

    private static String recursiveRemoveSpaces(String spaceChange) {
        if (spaceChange.length() == 0)
            return spaceChange;
        else if (spaceChange.charAt(0) == ' ') {
            spaceChange = '*' + spaceChange.substring(1);
        }
        return spaceChange.charAt(0) + recursiveRemoveSpaces(spaceChange.substring(1));

    }
}
//    Given a string, compute recursively a new string where all the adjacent chars are now separated by a *