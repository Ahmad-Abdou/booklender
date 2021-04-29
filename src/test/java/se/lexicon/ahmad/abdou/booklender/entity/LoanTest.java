package se.lexicon.ahmad.abdou.booklender.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootTest
public class LoanTest {

    Loan loan;
    Book book;
    LibraryUser libraryUser;

    @BeforeEach
    public void setup(){
        libraryUser = new LibraryUser();
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@gmail.com");

        book = new Book();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);

        loan = new Loan();
        loan.setLocalDate(LocalDate.now());
        loan.setTerminated(false);
        loan.setLoanTaker(libraryUser);
        loan.setBook(book);
    }
    @Test
    public void test_created(){
        Assertions.assertEquals(LocalDate.now(),loan.getLocalDate());
        Assertions.assertEquals(false,loan.isTerminated());
        Assertions.assertEquals(book,loan.getBook());
        Assertions.assertEquals(libraryUser,loan.getLoanTaker());
    }
    @Test
    public void test_equals(){
        libraryUser = new LibraryUser();
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@gmail.com");

        book = new Book();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);

        Loan actual = new Loan();
        actual.setLocalDate(LocalDate.now());
        actual.setTerminated(false);
        actual.setLoanTaker(libraryUser);
        actual.setBook(book);

        Assertions.assertTrue(actual.equals(loan));
    }

    @Test
    public void test_hasCode(){
        libraryUser = new LibraryUser();
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@gmail.com");

        book = new Book();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);

        Loan actual = new Loan();
        actual.setLocalDate(LocalDate.now());
        actual.setTerminated(false);
        actual.setLoanTaker(libraryUser);
        actual.setBook(book);
        Assertions.assertEquals(actual.hashCode(),loan.hashCode());
    }

}
