package se.lexicon.ahmad.abdou.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.service.LibraryUserService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class LibraryUserController {

     LibraryUserService libraryUserService;

     @Autowired
    public void setLibraryUserService(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDto> findById(@PathVariable("id") long id){

         return ResponseEntity.status(HttpStatus.OK).body( libraryUserService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryUserDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(libraryUserService.findAll());
    }
    @GetMapping("/email")
    public ResponseEntity<LibraryUserDto> findByEmail(@RequestParam(value = "email") String email){
         return ResponseEntity.status(HttpStatus.OK).body(libraryUserService.findByEmail(email));
    }
    @PostMapping
    public ResponseEntity<LibraryUserDto> create(@RequestBody LibraryUserDto libraryUserDto){
         if(libraryUserDto == null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
         return ResponseEntity.status(HttpStatus.CREATED).body(libraryUserService.create(libraryUserDto));
    }
    @PutMapping
    public ResponseEntity<LibraryUserDto> update(@RequestBody LibraryUserDto libraryUserDto) {
        if(libraryUserDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(libraryUserService.update(libraryUserDto));
    }

}
