package streamexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercises {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream()
                .filter(n -> n.contains("2"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + " #" + s2);

        reduced.ifPresent(System.out::println);

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        List<String> myList2 = myList.stream()
                .filter(s -> s.contains("1"))
                .map(String:: toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(myList2);

        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1

        Stream.of("a1", "a2", "a3")
                .findAny()
                .ifPresent(System.out::println);  // a1

        IntStream.range(1, 6)
                .mapToObj(n -> Integer.toString(n) + " ||")
                .forEach(System.out::print);
        System.out.println();

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0
        System.out.println();


        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i + " ")
                .forEach(System.out::print);

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("\nfilter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("\n");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("\n");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

/*
    int max = 1000000;
    List<String> values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }
    long t0 = System.nanoTime();
    long count = values.stream().sorted().count();
    System.out.println(count);
    long t1 = System.nanoTime();
    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    System.out.println(String.format("sequential sort took: %d ms", millis));
// sequential sort took: 899 ms*/

    /*Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }
    map.forEach((id, val) -> System.out.print(val + " "));
    map.computeIfPresent(3, (num, val) -> val + num);
    System.out.println(map.get(3));             // val33
    map.computeIfPresent(9, (num, val) -> null);
    System.out.println(map.containsKey(9));     // false
    map.computeIfAbsent(23, num -> "val" + num);
    System.out.println(map.containsKey(23));    // true
    map.computeIfAbsent(3, num -> "bam");
    System.out.println(map.get(3));             // val33
    map.remove(3, "val3");
    System.out.println(map.get(3));             // val33
    map.remove(3, "val33");
    System.out.println(map.get(3));             // null*/
    }
}