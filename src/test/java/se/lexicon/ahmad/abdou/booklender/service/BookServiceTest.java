package se.lexicon.ahmad.abdou.booklender.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
import se.lexicon.ahmad.abdou.booklender.Exception.RecordNotFoundException;


import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class BookServiceTest {
    BookService bookService;
    BookDto bookDto;


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

      BookDto bookDto2 = new BookDto();
        bookDto2.setTitle("OCP");
        bookDto2.setAvailable(false);
        bookDto2.setDescription("learn advanced Java");
        bookDto2.setReserved(true);
        bookDto2.setFinePerDay(new BigDecimal(10));
        bookDto2.setMaxLoanDays(15);

//        bookService.create(bookDto);
//        bookService.create(bookDto2);
    }

    @Test
    public void findById() throws RecordNotFoundException {
       BookDto bookDto1 =  bookService.findById(1);
        System.out.println(bookDto1);
        Assertions.assertEquals(bookDto1,bookService.findAll().get(0));
    }

        @Test
    public void findAll(){
        List<BookDto> bookDtos= bookService.findAll();
            System.out.println(bookDtos);
    }
    @Test
    public void findByReserved(){
        List<BookDto> bookDtoList =bookService.findByReserved(false);
      Assertions.assertEquals(bookDtoList.get(0).isReserved(),bookDto.isReserved());
    }
    @Test
    public void findByAvailability(){
        List<BookDto> bookDtoList =bookService.findByAvailability(true);
        Assertions.assertEquals(bookDtoList.get(0).isAvailable(),bookDto.isAvailable());
    }
    @Test
    public void findByTitle(){
        List<BookDto> bookDtoList =bookService.findByTitle("OCA");
        Assertions.assertEquals(bookDtoList.get(0).getTitle(),bookDto.getTitle());
    }
    @Test
    public void update(){
       bookDto.setDescription("Be an expert Java developer");
       bookService.update(bookDto);
       Assertions.assertEquals("Be an expert Java developer",bookDto.getDescription());
    }
    @Test
    public void deleteById(){
        BookDto bookDto3 = new BookDto();
        bookDto3.setTitle("OCP");
        bookDto3.setAvailable(false);
        bookDto3.setDescription("learn advanced Java");
        bookDto3.setReserved(true);
        bookDto3.setFinePerDay(new BigDecimal(10));
        bookDto3.setMaxLoanDays(15);

//        BookDto expected =  bookService.create(bookDto3);
          int counter = bookService.findAll().size();
//        Assertions.assertEquals(true, bookService.deleteById(counter));
    }
}
