package se.lexicon.ahmad.abdou.booklender.service;


import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.Exception.DuplicateRecordException;
import se.lexicon.ahmad.abdou.booklender.Exception.RecordNotFoundException;

import java.util.List;

public interface LibraryUserService {

    LibraryUserDto create(LibraryUserDto libraryUserDto)throws DuplicateRecordException;

    LibraryUserDto update(LibraryUserDto libraryUserDto);

    LibraryUserDto findById(long id)throws RecordNotFoundException;

   LibraryUserDto findByEmail(String email);

    List<LibraryUserDto> findAll();

    boolean deleteById(long id);
}
