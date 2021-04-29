package se.lexicon.ahmad.abdou.booklender.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LibraryUserTest {
    LibraryUser libraryUser;

    @BeforeEach
    public void setup(){
        libraryUser = new LibraryUser();
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@gmail.com");
        libraryUser.setRegDate(LocalDate.now());

    }
    @Test
    public void test_created(){
        Assertions.assertEquals("Ahmad",libraryUser.getName());
        Assertions.assertEquals("test@gmail.com",libraryUser.getEmail());
        Assertions.assertEquals(LocalDate.now(),libraryUser.getRegDate());
    }

    @Test
    public void test_equals(){
        LibraryUser actual = new LibraryUser();
        actual.setName("Ahmad");
        actual.setEmail("test@gmail.com");
        actual.setRegDate(LocalDate.now());
        Assertions.assertTrue(libraryUser.equals(actual));
    }
    @Test
    public void test_hashCode(){
        LibraryUser actual = new LibraryUser();
        actual.setName("Ahmad");
        actual.setEmail("test@gmail.com");
        actual.setRegDate(LocalDate.now());
        Assertions.assertEquals(libraryUser.hashCode(),actual.hashCode());
    }
}
