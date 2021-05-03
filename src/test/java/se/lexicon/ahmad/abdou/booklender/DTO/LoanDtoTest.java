package se.lexicon.ahmad.abdou.booklender.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class LoanDtoTest {
    LoanDto loanDto;
    BookDto bookDto;
    LibraryUserDto libraryUserDto;

    @BeforeEach
    public void setup(){
        bookDto= new BookDto();
        bookDto.setTitle("OCA");
        bookDto.setAvailable(true);
        bookDto.setDescription("learn Java");
        bookDto.setReserved(false);
        bookDto.setFinePerDay(new BigDecimal(5));
        bookDto.setMaxLoanDays(10);

        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@gmail.com");
        libraryUserDto.setRegDate(LocalDate.now());

        loanDto = new LoanDto();
        loanDto.setBook(bookDto);
        loanDto.setLoanTaker(libraryUserDto);
        loanDto.setTerminated(false);
        loanDto.setLocalDate(LocalDate.now());
    }
    @Test
    public void test_created(){
        bookDto= new BookDto();
        bookDto.setTitle("OCA");
        bookDto.setAvailable(true);
        bookDto.setDescription("learn Java");
        bookDto.setReserved(false);
        bookDto.setFinePerDay(new BigDecimal(5));
        bookDto.setMaxLoanDays(10);

        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@gmail.com");
        libraryUserDto.setRegDate(LocalDate.now());

        Assertions.assertEquals(bookDto,loanDto.getBook());
        Assertions.assertEquals(libraryUserDto,loanDto.getLoanTaker());
        Assertions.assertEquals(false,loanDto.isTerminated());
        Assertions.assertEquals(LocalDate.now(),loanDto.getLocalDate());

    }
    @Test
    public void test_equals(){
        bookDto= new BookDto();
        bookDto.setTitle("OCA");
        bookDto.setAvailable(true);
        bookDto.setDescription("learn Java");
        bookDto.setReserved(false);
        bookDto.setFinePerDay(new BigDecimal(5));
        bookDto.setMaxLoanDays(10);

        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@gmail.com");
        libraryUserDto.setRegDate(LocalDate.now());

        LoanDto loanDto1 = new LoanDto();
        loanDto1.setBook(bookDto);
        loanDto1.setLoanTaker(libraryUserDto);
        loanDto1.setTerminated(false);
        loanDto1.setLocalDate(LocalDate.now());
        Assertions.assertTrue(loanDto1.equals(loanDto));
    }
    @Test
    public void test_hashCode(){
        bookDto= new BookDto();
        bookDto.setTitle("OCA");
        bookDto.setAvailable(true);
        bookDto.setDescription("learn Java");
        bookDto.setReserved(false);
        bookDto.setFinePerDay(new BigDecimal(5));
        bookDto.setMaxLoanDays(10);

        libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Ahmad");
        libraryUserDto.setEmail("test@gmail.com");
        libraryUserDto.setRegDate(LocalDate.now());

        LoanDto loanDto1 = new LoanDto();
        loanDto1.setBook(bookDto);
        loanDto1.setLoanTaker(libraryUserDto);
        loanDto1.setTerminated(false);
        loanDto1.setLocalDate(LocalDate.now());

        Assertions.assertEquals(loanDto1.hashCode(),loanDto.hashCode());

    }
}
