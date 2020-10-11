package streamCheatSheet;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamPractice {
    public static void main(String[] args) {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("Author" + i, "Book Title" + i, "Surname" + i, 46 + i);
        }


        List<String> filteredBooks = library.books.stream()
                .map(book -> book.getAuthor())
                .filter(author -> author.getAge() >= 50)
                .distinct()
                .limit(15)
                .map(Author::getSurname)
                .map(String::toUpperCase)
                .collect(toList());

        filteredBooks.forEach(System.out::println);


        Integer filteredBooksGender = library.books.stream()
                .map(Book::getAuthor)
                .filter(a -> a.getGender() == Gender.FEMALE)
                .map(Author::getAge)
                .filter(age -> age < 25)
                .reduce(0, Integer::sum);

        System.out.println(filteredBooksGender);
    }
}
