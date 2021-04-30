package se.lexicon.ahmad.abdou.booklender.service;


import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;

import java.util.List;

public interface LibraryUserService {

    LibraryUserDto create(LibraryUserDto libraryUserDto);

    LibraryUserDto update(LibraryUserDto libraryUserDto);

    LibraryUserDto findById(int id);

   LibraryUserDto findByEmail(String email);

    List<LibraryUserDto> findAll();

    boolean deleteById(int id);
}
