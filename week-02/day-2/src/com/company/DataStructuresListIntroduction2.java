package com.company;

import java.util.ArrayList;

public class DataStructuresListIntroduction2 {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();
        listA.add("Apple");
        listA.add("Avocado");
        listA.add("Blueberries");
        listA.add("Durian");
        listA.add("Lychee");

        ArrayList<String> listB = new ArrayList<>();
        listB.addAll(listA);

        System.out.println(listA.contains("Durian"));

        listB.remove("Durian");

        listA.add(3, "Kiwifruit");
//        System.out.println(listA);
        

    }
}
 /*   Create a list ('List A') which contains the following values
Apple, Avocado, Blueberries, Durian, Lychee
        Create a new list ('List B') with the values of List A
        Print out whether List A contains Durian or not
        Remove Durian from List B
        Add Kiwifruit to List A after the 4th element
        Compare the size of List A and List B
        Get the index of Avocado from List A
        Get the index of Durian from List B
        Add Passion Fruit and Pomelo to List B in a single statement
        Print out the 3rd element from List A*/