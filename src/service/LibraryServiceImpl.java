package service;

import library.model.Book;
import library.model.Loan;
import library.model.User;
import library.model.repository.BookRepository;
import library.model.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private List<Loan> loans;

    public LibraryServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.loans = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void registerUser(User user) {
        userRepository.registerUser(user);
    }

    @Override
    public Loan loanBook(String isbn, String userId) {
        Book book = bookRepository.findBookByISBN(isbn);
        User user = userRepository.findUserById(userId);

        if (book != null && book.isAvailable() && user != null) {
            book.setAvailable(false);
            Loan loan = new Loan(book, user, LocalDate.now().toString());
            loans.add(loan);
            return loan;
        }
        return null;
    }

    @Override
    public void returnBook(String isbn, String userId) {
        Loan loan = loans.stream()
                .filter(l -> l.getBook().getIsbn().equals(isbn) && l.getUser().getId().equals(userId))
                .findFirst()
                .orElse(null);

        if (loan != null) {
            loan.getBook().setAvailable(true);
            loan.setReturnDate(LocalDate.now().toString());
        }
    }

    @Override
    public List<Book> findBooks(String criteria) {
        return bookRepository.findBooks(criteria);
    }

    @Override
    public List<Loan> getLoans() {
        return loans;
    }
}
