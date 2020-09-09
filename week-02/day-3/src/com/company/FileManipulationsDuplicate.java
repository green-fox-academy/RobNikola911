package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManipulationsDuplicate {
    public static void main(String[] args) {
        new FileManipulationsDuplicate().replace();
    }

    public void replace() {
        String oldFileName = "duplicated-chars.txt";
        String tmpFileName = "noduplicated-chars.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));

            String line;
            while ((line = br.readLine()) != null) {
                String next = "";
                for (int i = 0; i < line.length(); i += 2) {
                    char c = line.charAt(i);
                    next += c;
                }
                bw.write(next + "\n");
            }
            bw.close();
        } catch (Exception e) {
            return;
        }
    }
}
//            Once everything is complete, delete old file..
//            File oldFile = new File(oldFileName);
//            oldFile.delete();

//            And rename tmp file's name to old file name
//            File newFile = new File(tmpFileName);
//            newFile.renameTo(oldFile);




// Create a method that decrypts the duplicated-chars.txt

/*        String str = "geeeekkksss";
        int n = str.length();
        System.out.println(decryptString(str, n));
    }
    static String decryptString(String str, int n) {
        int i = 0, next = 1;
        String decryptedStr = "";

        while (i < n) {
            decryptedStr += str.charAt(i);
            i += next;
            next++;
        }
        return decryptedStr;*/