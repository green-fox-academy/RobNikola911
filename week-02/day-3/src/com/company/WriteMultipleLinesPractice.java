package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class WriteMultipleLinesPractice {
    public static void main(String[] args) {
        String myFilePath = "src/com/my-file.txt";
        int fileLines = 5;
        String world = "Banana";

        getManipulate(myFilePath, world, fileLines);
    }

    private static void getManipulate(String path, String word, int lines) {
        try {
            FileWriter myFile = new FileWriter(path, false);
            for (int index = 0; index < lines; index++) {
                myFile.write(word + "\n");
            }
            myFile.close();
        } catch (IOException e) {
            System.out.println("Unable to write file: my-file.txt");
        }

    }
}

// Create a function that takes 3 parameters: a path, a word and a number
// and is able to write into a file.
//   The path parameter should be a string that describes the location of the file you wish to modify
//   The word parameter should also be a string that will be written to the file as individual lines
//   The number parameter should describe how many lines the file should have.
//   If the word is 'apple' and the number is 5, it should write 5 lines into the file and each line should read 'apple'
// The function should not raise any errors if it could not write the file.