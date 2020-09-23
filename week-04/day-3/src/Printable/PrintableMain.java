package Printable;

import java.util.ArrayList;
import java.util.List;

public class PrintableMain {

    public static void main(String[] args) {

        Domino domino1 = new Domino(3, 1);
        Domino domino2 = new Domino(5, 7);
        Domino domino3 = new Domino(7, 6);

        List<Domino> dominoes = new ArrayList<>();

        dominoes.add(domino1);
        dominoes.add(domino2);
        dominoes.add(domino3);

        Todo thing1 = new Todo("Buy milk", "high", true);
        Todo thing2 = new Todo("Do exercise", "high", false);
        Todo thing3 = new Todo("Buy bread", "low", true);

        List<Todo> todos = new ArrayList<>();

        todos.add(thing1);
        todos.add(thing2);
        todos.add(thing3);

        for (Domino d : dominoes) {
            d.printAllFields();
        }

        for (Todo t : todos) {
            t.printAllFields();
        }
    }
}