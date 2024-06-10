package service;

import library.model.Book;
import library.model.Loan;
import library.model.User;

import java.util.List;

public interface LibraryService {
    void addBook(Book book);
    void registerUser(User user);
    Loan loanBook(String isbn, String userId);
    void returnBook(String isbn, String userId);
    List<Book> findBooks(String criteria);
    List<Loan> getLoans();
}
