package library.model.repository;

import java.util.List;
import library.model.Book;

public interface BookRepository {
    void addBook(Book book);
    Book findBookByISBN(String isbn);
    List<Book> findBooks(String criteria);
}