package com.company;

public class RecursionChangeStringSpaces {
    public static void main(String[] args) {
        String mySentence = "All characters separated by stars.";
        System.out.println(recursiveStarAdder(mySentence));
    }

    public static String recursiveStarAdder(String addStar) {
        if (addStar.length() == 0) {
            return addStar;
        } else if (addStar.charAt(0) == ' ') {
            return addStar.charAt(0) + recursiveStarAdder(addStar.substring(1));
        } else {
            addStar = addStar.charAt(0) + "*" + addStar.substring(1);
        }
        return addStar.substring(0, 2) + recursiveStarAdder(addStar.substring(2));
    }
}

//    Given a string, compute recursively a new string where all the adjacent chars are now separated by a *