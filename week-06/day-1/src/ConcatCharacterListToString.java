import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatCharacterListToString {
    public static void main(String[] args) {

        List<Character> chars = Arrays.asList('T', 'e', 'c', 'h', 'i', 'e');

        String string = chars.stream()  			// Stream<Character>
                .map(String::valueOf)               // Stream<String>
                .collect(Collectors.joining());

        System.out.println(string);
    }
}
