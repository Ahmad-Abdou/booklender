package se.lexicon.ahmad.abdou.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;

public interface LibraryUserRepository extends CrudRepository<LibraryUser,Integer> {

    LibraryUser findByEmail(String email);
}
