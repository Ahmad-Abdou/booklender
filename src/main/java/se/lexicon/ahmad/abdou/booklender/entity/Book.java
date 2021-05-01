package se.lexicon.ahmad.abdou.booklender.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;

}
