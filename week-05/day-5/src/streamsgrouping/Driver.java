package streamsgrouping;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Driver {
    public static void main(String[] args) {
        List<Person> persons = populatedWithData();
        System.out.println("--------Obtain US and non-US based persons using partitioningBy and groupingBy------");
        System.out.println(persons.stream().collect(partitioningBy((Person p) -> p.getCountry().equals("US"))));
        System.out.println(persons.stream().collect(groupingBy((Person p) -> p.getCountry().equals("US"))));
        System.out.println("--------Count US and non-US based persons using partitioningBy and groupingBy------");
        System.out.println(persons.stream().collect(partitioningBy((Person p) -> p.getCountry().equals("US"), counting())));
        System.out.println(persons.stream().collect(groupingBy((Person p) -> p.getCountry().equals("US"), counting())));
        System.out.println("--------Obtain persons in each country and count them using groupingBy------");
        System.out.println(persons.stream().collect(groupingBy((Person p) -> p.getCountry())));
        System.out.println(persons.stream().collect(groupingBy((Person p) -> p.getCountry(), counting())));
        System.out.println("--------Obtain US and non-US based persons using partitioningBy and map names to Uppercase using maping------");
        System.out.println(persons.stream().collect(partitioningBy((Person p) -> p.getCountry().equals("US"),
                                                                    mapping(p -> p.getName().toUpperCase(),
                                                                    toList()))));
        System.out.println("--------Obtain persons in each country using groupingBy & map the names to uppercase using maping------");
        System.out.println(persons.stream().collect(groupingBy((Person p) -> p.getCountry(),
                                                                mapping(p -> p.getName().toUpperCase(),
                                                                toList()))));
    }

    static List<Person> populatedWithData() {
        Person person01 = new Person("Person01", "US");
        Person person02 = new Person("Person02", "US");
        Person person03 = new Person("Person03", "Brazil");
        Person person04 = new Person("Person04", "US");
        Person person05 = new Person("Person05", "Brazil");
        Person person06 = new Person("Person06", "US");
        Person person07 = new Person("Person07", "Germany");
        Person person08 = new Person("Person08", "US");

        List<Person> personList = new ArrayList<Person>();
        personList.add(person01);
        personList.add(person02);
        personList.add(person03);
        personList.add(person04);
        personList.add(person05);
        personList.add(person06);
        personList.add(person07);
        personList.add(person08);
        return personList;
    }
}
