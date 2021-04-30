package se.lexicon.ahmad.abdou.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;
import se.lexicon.ahmad.abdou.booklender.repository.LibraryUserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryUserServiceImpl implements LibraryUserService{

    LibraryUserRepository libraryUserRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setLibraryUserRepository(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {
        return modelMapper.map(libraryUserRepository.save(modelMapper.map(libraryUserDto, LibraryUser.class)),LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) {
        return modelMapper.map(libraryUserRepository.save(modelMapper.map(libraryUserDto, LibraryUser.class)),LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto findById(int id) {
        if(id <= 0) throw  new IllegalArgumentException("ID cannot be null");
       Optional<LibraryUser> libraryUser= libraryUserRepository.findById(id);
       if(libraryUser.isPresent()){
           return modelMapper.map(libraryUser.get(),LibraryUserDto.class);
       }
       else throw new IllegalArgumentException("ID Not Found");
    }

    @Override
    public LibraryUserDto findByEmail(String email) {
        return  modelMapper.map(libraryUserRepository.findByEmail(email),LibraryUserDto.class);
    }

    @Override
    public List<LibraryUserDto> findAll() {
        List<LibraryUser> libraryUsers = new ArrayList<>();
        libraryUserRepository.findAll().iterator().forEachRemaining(libraryUsers::add);
        return  libraryUsers.stream().map(libraryUser -> modelMapper.map(libraryUser,LibraryUserDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(int id) {
       Optional<LibraryUser> libraryUser = libraryUserRepository.findById(id);
       if(libraryUser.isPresent()){
           libraryUserRepository.deleteById(id);
           return true;
       }
      else return false;
    }
}
