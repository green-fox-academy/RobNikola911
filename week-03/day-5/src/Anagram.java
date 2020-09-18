import java.util.Arrays;

public class Anagram {

    public Boolean anagrams (String string1, String string2) {
        boolean status;
        if (string1.length() != string2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = string1.toLowerCase().toCharArray();
            char[] ArrayS2 = string2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;
    }
}
//    Write a function, that takes two strings and returns a boolean value based on if the two strings
//    are Anagramms or not.
//        Create a test for that.