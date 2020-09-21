import java.util.HashMap;
import java.util.Map;

public class CountLetters {


    public Map<String, Integer> dictionary(String word) {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();

        String[] pairs = word.split(",");     // "\\a" to go by characters
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            dictionary.put(keyValue[0], Integer.valueOf(keyValue[1]));
        }
        return dictionary;
    }
}
/*
    Write a function, that takes a string as an argument and returns a dictionary
     with all letters in the string as keys, and numbers as values that shows how many occurrences there are.
        Create a test for that.*/
