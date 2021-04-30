package se.lexicon.ahmad.abdou.booklender.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class LibraryUserRepositoryTest {
    LibraryUser libraryUser;
    LibraryUserRepository libraryUserRepository;

    @Autowired
    public void setLibraryUserRepository(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @BeforeEach
    public void setup(){
        libraryUser = new LibraryUser();
        libraryUser.setRegDate(LocalDate.now());
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@gmail.com");

    }
    @Test
    public void test_created(){
       LibraryUser libraryUser2 = libraryUserRepository.save(libraryUser);

        Assertions.assertEquals(libraryUser,libraryUser2);
    }
    @Test
    public void test_findByEmail(){
        LibraryUser libraryUser2 = libraryUserRepository.findByEmail("test@gmail.com");
        Assertions.assertEquals(libraryUser.getEmail(),libraryUser2.getEmail());
    }
}
