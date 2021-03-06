package se.lexicon.ahmad.abdou.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.DTO.LoanDto;
import se.lexicon.ahmad.abdou.booklender.Exception.ArgumentException;
import se.lexicon.ahmad.abdou.booklender.Exception.RecordNotFoundException;
import se.lexicon.ahmad.abdou.booklender.service.BookService;
import se.lexicon.ahmad.abdou.booklender.service.LibraryUserService;
import se.lexicon.ahmad.abdou.booklender.service.LoanService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {
    LoanService loanService;
    BookService bookService;
    LibraryUserService libraryUserService;
    private LoanDto savingDto;

    @PostConstruct
    public void setup(){
        savingDto = new LoanDto();
    }

    @Autowired
    public LoanController(LoanService loanService, BookService bookService, LibraryUserService libraryUserService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> findById(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<LoanDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findAll());
    }
    @PostMapping
    public ResponseEntity<LoanDto> create(@RequestBody LoanDto loanDto) throws ArgumentException, RecordNotFoundException {
        if(loanDto==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
       BookDto bookDto = bookService.findById(loanDto.getBook().getBookId());
       LibraryUserDto libraryUserDto = libraryUserService.findById(loanDto.getLoanTaker().getUserId());

        savingDto.setBook(bookDto);
        savingDto.setLoanTaker(libraryUserDto);
        savingDto= loanService.create(loanDto);


        return ResponseEntity.status(HttpStatus.CREATED).body(savingDto);
    }
    @PutMapping
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto loanDto){
        if(loanDto==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loanService.update(loanDto));
    }
    @GetMapping("/book")
    public ResponseEntity<List<LoanDto>> findByBookId(@RequestParam("id") Long id) throws ArgumentException {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findByBookId(id));
    }
    @GetMapping("/user")
    public ResponseEntity<List<LoanDto>> findByUserId(@RequestParam("id") Long id) throws RecordNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findByUserId(id));
    }
}
