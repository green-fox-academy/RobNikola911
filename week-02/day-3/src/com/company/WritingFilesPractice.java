package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WritingFilesPractice {
    public static void main(String[] args) {

        System.out.println(getManipulate());

    }

    private static List getManipulate() {
        List<String> myFile = new ArrayList();
        myFile.add("Robert Nikola");
        try {
            Path filePath = Paths.get("src/com/my-file.txt");
            Files.write(filePath, myFile);

        } catch (IOException e) {
            System.out.println("Unable to write file: my-file.txt");
        }
        return myFile;
    }
}
// Write a function that is able to manipulate a file
// By writing your name into it as a single line
// The file should be named "my-file.txt"
// In case the program is unable to write the file,
// It should print the following error message: "Unable to write file: my-file.txt"