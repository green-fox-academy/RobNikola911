import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExerciseSquaredValueMoreThan20 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);

        List<Integer> squaredValueMoreThan20 = numbers.stream()
                .filter(n -> n * n > 20)
                .collect(Collectors.toList());

        System.out.println(squaredValueMoreThan20);
    }
}
