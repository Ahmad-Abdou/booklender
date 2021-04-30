package se.lexicon.ahmad.abdou.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.ahmad.abdou.booklender.entity.Book;

import java.util.List;

public interface BookRepository  extends CrudRepository<Book,Integer> {


    List<Book> findBookByReserved(boolean reserved);

    List<Book> findBookByAvailable(boolean available);

    List<Book> findBookByTitle(String title);



}
