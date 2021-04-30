package se.lexicon.ahmad.abdou.booklender.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.DTO.LoanDto;
import se.lexicon.ahmad.abdou.booklender.entity.Book;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;
import se.lexicon.ahmad.abdou.booklender.entity.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class LoanServiceTest {
     LoanDto loanDto;
     BookDto bookDto;
     LibraryUserDto libraryUserDto;
     LoanService loanService;
     LibraryUserService libraryUserService;
     BookService bookService;

     @Autowired
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }
    @Autowired
    public void setLibraryUserService(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    @BeforeEach
    public void setup(){
        bookDto = new BookDto();
        bookDto.setTitle("OCA");
        bookDto.setAvailable(true);
        bookDto.setDescription("learn Java");
        bookDto.setReserved(false);
        bookDto.setFinePerDay(new BigDecimal(5));
        bookDto.setMaxLoanDays(10);
        bookService.create(bookDto);

        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setRegDate(LocalDate.now());
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@3.com");
        libraryUserService.create(libraryUserDto);

        loanDto = new LoanDto();
        loanDto.setLoanTakerDto(libraryUserDto);
        loanDto.setBookDto(bookDto);
        loanDto.setLocalDate(LocalDate.now());
        loanDto.setTerminated(false);
       loanService.create(loanDto);
    }
    @Test
    public void findAll(){

        System.out.println(loanService.findAll());
    }

    @Test
    public void findById(){
//       LoanDto loan2=loanService.create(loanDto);
//        System.out.println(loan2);
//        LoanDto loan=  loanService.findById(2);
//        Assertions.assertEquals(loan2,);

    }

}
