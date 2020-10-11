package steamExercise;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class LambdaExplanations {
    public static void main(String[] args) {
        Runnable aBlockOfCode = () -> System.out.println("Hello World");
        aBlockOfCode.run();

        IntFunction<Integer> doubleNumberFunction = (int a) -> a * 2;
        System.out.println(doubleNumberFunction.apply(5));

        IntBinaryOperator addFunction = (int a, int b) -> a + b;
        System.out.println(addFunction.applyAsInt(4,5));

        IntBinaryOperator safeDivideFunction = (int a, int b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println(safeDivideFunction.applyAsInt(10, 0));

        Function<String, Integer> stringLenghtCountFunction = (String s) -> s.length();
        System.out.println(stringLenghtCountFunction.apply("Whats the lenght?"));
    }
}
/*
aBlockOfCode = public void perform() {
        System.out.print("Hello World");
        }
*/
