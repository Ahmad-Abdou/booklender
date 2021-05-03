package se.lexicon.ahmad.abdou.booklender.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private LocalDate regDate;
    private String name;
    @Column(unique = true)
    private String email;


}
