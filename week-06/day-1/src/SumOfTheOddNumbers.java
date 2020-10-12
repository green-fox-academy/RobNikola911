import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfTheOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6,
                7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

        Integer sumOddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(n -> n).sum();

        System.out.println(sumOddNumbers);
    }
}
