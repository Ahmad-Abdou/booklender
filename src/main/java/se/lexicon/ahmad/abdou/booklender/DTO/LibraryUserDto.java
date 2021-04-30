package se.lexicon.ahmad.abdou.booklender.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class LibraryUserDto {
    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUserDto(LocalDate regDate, String name, String email) {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public LibraryUserDto() {
    }


}
