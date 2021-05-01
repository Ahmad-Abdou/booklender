package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class LibraryUserDto {
    private long userId;
    private LocalDate regDate;
    private String name;
    private String email;



    public LibraryUserDto() {
    }


}
