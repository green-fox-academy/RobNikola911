package com.company;

public class StringMethodsTakesLonger {
    public static void main(String... args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        // When saving this quote a disk error has occurred. Please fix it.
        // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
        // Using pieces of the quote variable (instead of just redefining the string)

        System.out.println("\"Hofstadter's Law: It".concat(" always takes longer than ").concat("you expect, even when you take into account Hofstadter's Law.\""));
    }
}
   /* StringBuilder sb = new StringBuilder();
        sb.append("Return");
        sb.append(" of ");
        sb.append("the king.");*/