package sda.mvn.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private final List<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void add(Book book) {
        books.add(book);
    }
}
