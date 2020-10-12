
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class FrequencyOfCharactersInString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please give a word: ");
        String word = sc.nextLine();

/*        Map<Character, Integer> frequencies = word.chars().boxed()
                .collect(toMap(
                        k -> Character.valueOf((char) k.intValue()), // key = char
                        counter -> 1,         // 1 occurence
                        Integer::sum)); // counting
        System.out.println("Frequencies:\n" + frequencies);*/

/*        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqs.merge(c,                  // key = char
                    1,                  // value to merge
                    Integer::sum);      // counting
        }
        System.out.println("Frequencies:\n" + freqs);*/

        Map<Character, Long> occurence =
        word.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        System.out.println(occurence);
    }
}