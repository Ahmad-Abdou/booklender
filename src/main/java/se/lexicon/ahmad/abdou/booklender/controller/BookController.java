package se.lexicon.ahmad.abdou.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
import se.lexicon.ahmad.abdou.booklender.Exception.RecordNotFoundException;
import se.lexicon.ahmad.abdou.booklender.service.BookService;
import java.util.List;


@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

      @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBYID(@PathVariable("id") long id) throws RecordNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
      }
      @GetMapping
    public ResponseEntity<List<BookDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
      }
      @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto){
        if(bookDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookDto));
      }
      @PutMapping
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
          if(bookDto == null){
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
          return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookService.update(bookDto));
      }
      @GetMapping("/find")
    public ResponseEntity<List<BookDto>> find(@RequestParam(value = "title",required = false) String title,
                                              @RequestParam(value = "available",required = false) boolean available,
                                              @RequestParam(value = "reserved",required = false) boolean reserved){
        List<BookDto> titleList=  bookService.findByTitle(title);
        List<BookDto> availableList = bookService.findByAvailability(available);
        List<BookDto> reservedList = bookService.findByReserved(reserved);


        if(title !=null ){
            return ResponseEntity.status(HttpStatus.OK).body(titleList);
        }
        if(available){
            return ResponseEntity.status(HttpStatus.OK).body(availableList);
        }
        if(reserved){
            return ResponseEntity.status(HttpStatus.OK).body(reservedList);
        }

        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }

}
