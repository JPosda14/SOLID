package library.model.main;

import library.model.Book;
import library.model.Loan;
import library.model.User;
import library.model.repository.BookRepository;
import library.model.repository.BookRepositoryImpl;
import library.model.repository.UserRepository;
import library.model.repository.UserRepositoryImpl;
import service.LibraryService;
import service.LibraryServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        LibraryService libraryService = new LibraryServiceImpl(bookRepository, userRepository);

        libraryService.addBook(new Book("55654", "Satanás", "Mario Mendoza"));
        libraryService.addBook(new Book("15556", "El Arte de la Guerra", "Sun Tzu"));

        libraryService.registerUser(new User("1", "Juan"));
        libraryService.registerUser(new User("2", "Toro"));

        Loan loan = libraryService.loanBook("55654", "1");
        if (loan != null) {
            System.out.println("Prestamo exitoso: " + loan.getBook().getTitle() + " para " + loan.getUser().getName());
        } else {
            System.out.println("El prestamó no se hizp.");
        }

        libraryService.returnBook("55654", "1");
        System.out.println("Libro retornado.");

        List<Book> books = libraryService.findBooks("El Arte de la Guerra");
        for (Book book : books) {
            System.out.println("Libro encotrado: " + book.getTitle());
        }

        List<Loan> loans = libraryService.getLoans();
        for (Loan l : loans) {
            System.out.println("Prestamo: " + l.getBook().getTitle() + " - " + l.getUser().getName() + " - " + l.getLoanDate());
        }
    }
}