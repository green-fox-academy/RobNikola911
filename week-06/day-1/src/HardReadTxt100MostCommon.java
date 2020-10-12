import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class HardReadTxt100MostCommon {
    public static void main(String[] args) throws IOException {
        List<String> words = readFileIn("example.txt");


        Map<String, Long> mostCommonWords = words.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        mostCommonWords.entrySet()
                .stream()
               .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
               .limit(10)
                .forEach(System.out::println);
    }

    public static List<String> readFileIn (String fileName) throws IOException {
        List<String> words;
        String article = "";
        Path path = Path.of("src/" + fileName);
        try {
            article = Files.readString(path);
        } catch (IOException ioe) {
            System.out.println("No such file!");
        }
        words = Arrays.asList(article.split(" "));
        return words;

    }
}
