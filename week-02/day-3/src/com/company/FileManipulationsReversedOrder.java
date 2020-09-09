package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManipulationsReversedOrder {
    public static void main(String[] args) {
        new FileManipulationsReversedOrder().replace();
    }

    public void replace() {
        String oldFileName = "reversed-order.txt";
        String tmpFileName = "nonreversed-order.txt";


        try {
            List<String> text = Files.readAllLines(Paths.get(oldFileName));
            Collections.reverse(text);
            Files.write(Paths.get(tmpFileName), text);
        } catch (Exception e) {
            return;
        }
    }
}
