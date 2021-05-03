package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BookDto {
    private long bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;
    private List<LoanDto> loanDtoList;

    public BookDto() {
    }

}
