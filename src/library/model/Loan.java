package library.model;

public class Loan {
    private Book book;
    private User user;
    private String loanDate;
    private String returnDate;

    public Loan(Book book, User user, String loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
