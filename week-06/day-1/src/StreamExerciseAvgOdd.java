import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExerciseAvgOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3,
                -8, 12, 19, 6, 9, 10, 14);

        Integer avgOdd = (int) numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(Integer::intValue)
                .average().getAsDouble();

        System.out.println(avgOdd);

        Double avgOdd2 = numbers.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.averagingInt(n -> n));

        System.out.println(avgOdd2);
    }
}

/*    Integer avg = (int) money.stream()
            .mapToInt(Integer::intValue)
            .average().getAsDouble();
        System.out.println(avg);*/
