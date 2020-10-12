import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindUppercaseCharInString {
    public static void main(String[] args) {
        String example = "This String Has UpperCase Characters";

        example.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> Character.toString(c))
                .map(c -> c + " ")
//                .forEach(c -> System.out.print((char) c + " "));
                .forEach(System.out::print);


    }
}
