package steamExercise;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class EvenNumberPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

class ForEach implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}

public class LambdaBehindTheScreensRunner {
    public static void main(String[] args) {
        List.of(23, 43, 34, 45, 36, 48).stream()
                .filter(n -> n % 2 == 0)
                .forEach(e -> System.out.println(e));

        List.of(23, 43, 34, 45, 36, 48).stream()
                .filter(new EvenNumberPredicate())
                .forEach(new ForEach());

//        Stream<T> filter(Predicate<? super T> predicate);
//        boolean test(T t);
//         void forEach(Consumer<? super T> action);
//        void accept(T t);

    }
}
