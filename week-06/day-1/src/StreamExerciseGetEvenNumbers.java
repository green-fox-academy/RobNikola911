import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExerciseGetEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8,
                12, 19, 6, 9, 10, 14);

/*        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);*/

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
