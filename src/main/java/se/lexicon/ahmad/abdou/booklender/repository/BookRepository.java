package se.lexicon.ahmad.abdou.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.ahmad.abdou.booklender.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository  extends CrudRepository<Book,Integer> {



     Optional<Book> findByBookId(long id);

     boolean deleteByBookId(long id);

    List<Book> findBookByReserved(boolean reserved);

    List<Book> findBookByAvailable(boolean available);

    List<Book> findBookByTitle(String title);



}
