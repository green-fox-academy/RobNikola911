package streamCheatSheet;

public class Book {
    protected Author author;
    protected String name;

    public Book(String author, String name, String surname, int age) {
        this.author = new Author(author, age, surname);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Author getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", name='" + name + '\'' +
                '}';
    }
}
