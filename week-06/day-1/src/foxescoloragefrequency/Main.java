package foxescoloragefrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Fox> foxes = new ArrayList<>(Arrays.asList(
                new Fox("Rix", "Green", 7),
                new Fox("Asd", "Red", 4),
                new Fox("Qwe", "Yellow", 6),
                new Fox("Zxc", "Green", 3),
                new Fox("Fgh", "Purple", 6)
        ));

//        find the foxes with green color!

        foxes.stream()
                .filter(fox -> fox.getColor().equals("Green"))
//                .map(Fox::getName) // map by name
                .collect(Collectors.toList()) //with map only the names are in the list
                .forEach(System.out::println);

        System.out.println();
//        find the foxes with green color, and age less then 5 years!
        foxes.stream()
                .filter(fox -> fox.getColor().equals("Green"))
                .filter(fox -> fox.getAge() < 5)
                .map(Fox::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        find the frequency of foxes by color!
/*        Map<Character, Long> occurence =
                word.chars().mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(o -> o, Collectors.counting()));*/
        Map<String, Long> frequencyByColor = foxes.stream()
                .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));

        System.out.println(frequencyByColor);

    }
}
