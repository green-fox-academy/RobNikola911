package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManipulationsReversedLines {
    public static void main(String[] args) {
        new FileManipulationsReversedLines().replace();
    }

    public void replace() {
        String oldFileName = "reversed-lines.txt";
        String tmpFileName = "nonreversed-lines.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));

            String line;
            while ((line = br.readLine()) != null) {
                String next = "";
                for (int i = line.length() - 1; i >= 0; i --) {
                    next += line.charAt(i);
                }
                bw.write(next + "\n");
            }
            bw.close();
        } catch (Exception e) {
            return;
        }
    }
}
// Create a method that decrypts reversed-lines.txt