package se.lexicon.ahmad.abdou.booklender.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;

import java.time.LocalDate;

@SpringBootTest
public class LibraryUserDtoTest {

    LibraryUserDto libraryUserDto;

    @BeforeEach
    public void setup(){
        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@gmail.com");
        libraryUserDto.setRegDate(LocalDate.now());
    }
    @Test
    public void test_created(){
        Assertions.assertEquals("Ahmad",libraryUserDto.getName());
        Assertions.assertEquals("test@gmail.com",libraryUserDto.getEmail());
        Assertions.assertEquals(LocalDate.now(),libraryUserDto.getRegDate());
    }
    @Test
    public void test_equals(){
      LibraryUserDto  libraryUserDto2 = new LibraryUserDto();
        libraryUserDto2.setName("Ahmad");
        libraryUserDto2.setEmail("test@gmail.com");
        libraryUserDto2.setRegDate(LocalDate.now());
        Assertions.assertTrue(libraryUserDto2.equals(libraryUserDto));
    }
    @Test
    public void test_hashCode(){
        LibraryUserDto  libraryUserDto2 = new LibraryUserDto();
        libraryUserDto2.setName("Ahmad");
        libraryUserDto2.setEmail("test@gmail.com");
        libraryUserDto2.setRegDate(LocalDate.now());
        Assertions.assertEquals(libraryUserDto2.hashCode(),libraryUserDto.hashCode());
    }
}
