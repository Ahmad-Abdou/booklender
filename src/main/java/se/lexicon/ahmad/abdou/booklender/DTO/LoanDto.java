package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LoanDto {
    private long loanId;
    private LibraryUserDto loanTaker ;
    private BookDto book;
    private LocalDate localDate;
    private boolean terminated;


    public LoanDto(LibraryUserDto loanTaker, BookDto book, LocalDate localDate, boolean terminated) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.localDate = localDate;
        this.terminated = terminated;
    }

    public LoanDto() {
    }

}
