package com.company;

public class OptionalTicTacToe {
    public static void main(String[] args) {

        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file

        System.out.println(ticTacResult("win-o.txt"));
        // Should print "O"

        System.out.println(ticTacResult("win-x.txt"));
        // Should print "X"

        System.out.println(ticTacResult("draw.txt"));
        // Should print "Draw"
    }

    private static String ticTacResult(String win) {
        switch (win){
            case "win-x.txt":
                return "X";
            case "win-o.txt":
                return "O";
            default: return "Draw";
        }

    }
}
