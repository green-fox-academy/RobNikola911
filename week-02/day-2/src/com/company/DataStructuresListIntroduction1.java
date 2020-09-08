package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class DataStructuresListIntroduction1 {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("William");
        names.add("John");
        names.add("Amanda");
        names.remove(1);
        int index = 1;
        for (String s : names) {
            System.out.println((index++) + ". " + s);
        }

        Collections.reverse(names);
        int reverseIndex = 1;
        for (String s : names) {
            System.out.println((reverseIndex++) + ". " + s);
        }
//        printElements(names);
//    }
//
//    // Iterate through all the elements and print
//    public static String printElements(ArrayList<Integer> names)
//    {
//        for (int i = 0; i < names.size(); i++) {
//            System.out.print(names.get(i) + " ");
//        }
    }
}

