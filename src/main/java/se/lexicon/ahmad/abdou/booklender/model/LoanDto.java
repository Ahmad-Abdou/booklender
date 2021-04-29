package se.lexicon.ahmad.abdou.booklender.model;

import java.time.LocalDate;
import java.util.Objects;

public class LoanDto {
    private long loanId;
    private LibraryUserDto loanTaker ;
    private BookDto bookDto;
    private LocalDate localDate;
    private boolean terminated;

    public LoanDto(LibraryUserDto loanTaker, BookDto bookDto, LocalDate localDate, boolean terminated) {
        this.loanTaker = loanTaker;
        this.bookDto = bookDto;
        this.localDate = localDate;
        this.terminated = terminated;
    }

    public long getLoadId() {
        return loanId;
    }


    public LibraryUserDto getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDto loanTaker) {
        this.loanTaker = loanTaker;
    }

    public BookDto getBook() {
        return bookDto;
    }

    public void setBook(BookDto bookDto) {
        this.bookDto = bookDto;
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
        LoanDto loanDto = (LoanDto) o;
        return loanId == loanDto.loanId && terminated == loanDto.terminated && Objects.equals(loanTaker, loanDto.loanTaker) && Objects.equals(bookDto, loanDto.bookDto) && Objects.equals(localDate, loanDto.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanTaker, bookDto, localDate, terminated);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + bookDto +
                ", localDate=" + localDate +
                ", terminated=" + terminated +
                '}';
    }
}
