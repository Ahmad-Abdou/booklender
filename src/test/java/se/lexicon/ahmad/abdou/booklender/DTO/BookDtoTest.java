package se.lexicon.ahmad.abdou.booklender.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;

@SpringBootTest
public class BookDtoTest {
    BookDto bookdto;

    @BeforeEach
    public void setup(){
        bookdto = new BookDto();
        bookdto.setTitle("OCA");
        bookdto.setAvailable(true);
        bookdto.setDescription("learn Java");
        bookdto.setReserved(false);
        bookdto.setFinePerDay(new BigDecimal(5));
        bookdto.setMaxLoanDays(10);
    }
    @Test
    public void test_created(){
        Assertions.assertEquals("OCA",bookdto.getTitle());
        Assertions.assertEquals(true,bookdto.isAvailable());
        Assertions.assertEquals("learn Java",bookdto.getDescription());
        Assertions.assertEquals(false,bookdto.isReserved());
        Assertions.assertEquals(BigDecimal.valueOf(5),bookdto.getFinePerDay());
        Assertions.assertEquals(10,bookdto.getMaxLoanDays());
    }
    @Test
    public void test_equals(){
        BookDto bookDto2 = new BookDto();
        bookDto2.setTitle("OCA");
        bookDto2.setAvailable(true);
        bookDto2.setDescription("learn Java");
        bookDto2.setReserved(false);
        bookDto2.setFinePerDay(new BigDecimal(5));
        bookDto2.setMaxLoanDays(10);
       Assertions.assertTrue(bookDto2.equals(bookdto));
    }
    @Test
    public void test_hashCode(){
        BookDto book2 = new BookDto();
        book2.setTitle("OCA");
        book2.setAvailable(true);
        book2.setDescription("learn Java");
        book2.setReserved(false);
        book2.setFinePerDay(new BigDecimal(5));
        book2.setMaxLoanDays(10);
        Assertions.assertEquals(book2.hashCode(),bookdto.hashCode());
    }

}
