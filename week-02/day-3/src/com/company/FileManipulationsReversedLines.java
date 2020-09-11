package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManipulationsReversedLines {
    public static void main(String[] args) {
        String oldFileName = "reversed-lines.txt";
        String tmpFileName = "nonreversed-lines.txt";
        if (replace(oldFileName, tmpFileName)) {
            System.out.println("Reverse was successful!");
        } else {
            System.out.println("Reverse was unsuccessful!");
        }
    }

    private static boolean replace(String oldFileName, String tmpFileName) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));

            String line;
            while ((line = br.readLine()) != null) {
                String next = "";
                for (int i = line.length() - 1; i >= 0; i--) {
                    next += line.charAt(i);
                }
                bw.write(next + "\n");
            }
            bw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
// Create a method that decrypts reversed-lines.txt