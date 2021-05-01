package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookDto {
    private long bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;


    public BookDto() {
    }

}
