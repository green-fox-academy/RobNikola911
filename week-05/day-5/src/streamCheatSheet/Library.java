package streamCheatSheet;

import java.util.ArrayList;
import java.util.List;


public class Library {

    protected List<Book> books;


    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String author, String book, String surname, int age) {
        books.add(new Book(author, book, surname, age));
    }

}
