package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ExceptionCountLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Filename: ");
        String userInput = scanner.nextLine();
        System.out.println("The number of lines: " + getFileSize(userInput));
    }

    private static int getFileSize(String userInput) {
        Path filePath = Paths.get("src/com/" + userInput + ".txt");
        List<String> myFile = null;
        try {
            myFile = Files.readAllLines(filePath);

        } catch (IOException e) {
            return 0;
        }
        return myFile.size();
    }
}


// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.