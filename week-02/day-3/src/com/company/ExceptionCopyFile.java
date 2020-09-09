package com.company;

import java.io.*;

public class ExceptionCopyFile {
    public static void main(String[] args) {
        String fileName = "Copythisfile.txt";
        String fileName2 = "Copythisfile2.txt";
        if (getCopyFile(fileName, fileName2)) {
            System.out.println("File copy was successful!");
        } else {
            System.out.println("File copy was unsuccessful!");
        }
    }

    private static boolean getCopyFile(String name, String name2) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(name);
            os = new FileOutputStream(name2);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful