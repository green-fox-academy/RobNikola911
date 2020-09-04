package com.company;

public class DrawChessTable {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i < 9; i++) {
            for (j = 1; j < 9; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("%");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// Crate a program that draws a chess table like this
//
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
//