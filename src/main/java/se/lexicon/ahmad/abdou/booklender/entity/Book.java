package se.lexicon.ahmad.abdou.booklender.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;
    @OneToMany(mappedBy = "book")
    private List<Loan> loans;
}
