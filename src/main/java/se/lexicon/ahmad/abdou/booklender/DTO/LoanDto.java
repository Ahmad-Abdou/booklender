package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LoanDto {
    private long loanId;
    private LibraryUserDto loanTakerDto ;
    private BookDto bookDto;
    private LocalDate localDate;
    private boolean terminated;

    public LoanDto(LibraryUserDto loanTaker, BookDto bookDto, LocalDate localDate, boolean terminated) {
        this.loanTakerDto = loanTaker;
        this.bookDto = bookDto;
        this.localDate = localDate;
        this.terminated = terminated;
    }

    public LoanDto() {
    }


}
