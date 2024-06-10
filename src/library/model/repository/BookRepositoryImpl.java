package library.model.repository;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    public BookRepositoryImpl() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findBookByISBN(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    @Override
    public List<Book> findBooks(String criteria) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(criteria) || book.getAuthor().contains(criteria)) {
                result.add(book);
            }
        }
        return result;
    }
}
