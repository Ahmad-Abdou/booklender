package se.lexicon.ahmad.abdou.booklender.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookTest {

    Book book;

    @BeforeEach
    public void setup(){
        book = new Book();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);
    }


    @Test
    public void test_created(){
        Assertions.assertEquals("OCA",book.getTitle());
        Assertions.assertEquals("learn Java",book.getDescription());
        Assertions.assertEquals(10,book.getMaxLoanDays());
        Assertions.assertEquals(false,book.isReserved());
        Assertions.assertEquals(true,book.isAvailable());
        Assertions.assertEquals(BigDecimal.valueOf(5),book.getFinePerDay());
    }
    @Test
    public void test_equal(){
        Book actual = new Book();
        actual.setTitle("OCA");
        actual.setAvailable(true);
        actual.setDescription("learn Java");
        actual.setReserved(false);
        actual.setFinePerDay(new BigDecimal(5));
        actual.setMaxLoanDays(10);
        Assertions.assertTrue(book.equals(actual));
    }
    @Test
    public void test_hashCode(){
        Book actual = new Book();
        actual.setTitle("OCA");
        actual.setAvailable(true);
        actual.setDescription("learn Java");
        actual.setReserved(false);
        actual.setFinePerDay(new BigDecimal(5));
        actual.setMaxLoanDays(10);
        Assertions.assertEquals(book.hashCode(),actual.hashCode());
    }

}
