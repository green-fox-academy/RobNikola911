package com.company;

public class StringMethodsReverse {
    public static void main(String... args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        String reverse = "";

        for (int i = toBeReversed.length() - 1; i >= 0; i--) {
            reverse = reverse + toBeReversed.charAt(i);
        }

        System.out.println(reverse);

/*        String reverse;
        public static String reverse(String toBeReversed) {
            int i, len = toBeReversed.length();
            StringBuilder dest = new StringBuilder(len);

            for (i = (len - 1); i >= 0; i--){
                dest.append(toBeReversed.charAt(i));
            }

            return dest.toString();
        }*/
        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.

//        System.out.println(reverse(toBeReversed));
    }
}