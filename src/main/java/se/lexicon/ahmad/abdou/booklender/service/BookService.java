package se.lexicon.ahmad.abdou.booklender.service;

import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;

import java.util.List;

public interface BookService {

     List<BookDto> findByReserved(boolean reserved);

     List<BookDto> findByAvailability(boolean available);

     List<BookDto> findByTitle(String title);

     BookDto findById(long id);

     List<BookDto> findAll();

     BookDto create(BookDto bookDto);

     BookDto update(BookDto bookDto);

     boolean deleteById(long id);


}
