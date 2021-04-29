package se.lexicon.ahmad.abdou.booklender.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private LibraryUser loanTaker ;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDate localDate;
   @Column(name = "loan_status")
    private boolean terminated;

}
