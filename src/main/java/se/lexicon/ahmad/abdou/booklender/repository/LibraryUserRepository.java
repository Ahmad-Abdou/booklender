package se.lexicon.ahmad.abdou.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser,Integer> {

    Optional<LibraryUser> findByUserId(long id);

    LibraryUser deleteByUserId(long id);

    LibraryUser findByEmail(String email);
}
