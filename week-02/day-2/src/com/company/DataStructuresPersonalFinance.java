package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class DataStructuresPersonalFinance {
    public static void main(String[] args) {

        ArrayList<Integer> money = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        Integer sum = money.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        Integer max = money.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
        System.out.println(max);

        Integer min = money.stream()
                .mapToInt(Integer::intValue)
                .min().getAsInt();
        System.out.println(min);

        Integer avg = (int) money.stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
        System.out.println(avg);
    }
}
/*
    We are going to represent our expenses in a list containing integers.
        Create a list with the following items.
        500, 1000, 1250, 175, 800 and 120
        Create an application which solves the following problems.
        How much did we spend?
        Which was our greatest expense?
        Which was our cheapest spending?
        What was the average amount of our spendings?*/
