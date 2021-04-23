package model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private long loanId;
    private LibraryUser loanTaker ;
    private Book book;
    private LocalDate localDate;
    private boolean terminated;

    public Loan(LibraryUser loanTaker, Book book, LocalDate localDate, boolean terminated) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.localDate = localDate;
        this.terminated = terminated;
    }

    public long getLoadId() {
        return loanId;
    }


    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId && terminated == loan.terminated && Objects.equals(loanTaker, loan.loanTaker) && Objects.equals(book, loan.book) && Objects.equals(localDate, loan.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanTaker, book, localDate, terminated);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", localDate=" + localDate +
                ", terminated=" + terminated +
                '}';
    }
}
