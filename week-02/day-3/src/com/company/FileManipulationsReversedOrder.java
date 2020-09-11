package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileManipulationsReversedOrder {
    public static void main(String[] args) {
        String oldFileName = "reversed-order.txt";
        String tmpFileName = "nonreversed-order.txt";
        if (replace(oldFileName, tmpFileName)) {
            System.out.println("Reverse was successful!");
        } else {
            System.out.println("Reverse was unsuccessful!");
        }
    }

    private static boolean replace(String oldFileName, String tmpFileName) {
        try {
            List<String> text = Files.readAllLines(Paths.get(oldFileName));
            Collections.reverse(text);
            Files.write(Paths.get(tmpFileName), text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
