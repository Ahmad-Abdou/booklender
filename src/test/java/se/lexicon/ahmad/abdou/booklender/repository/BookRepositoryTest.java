package se.lexicon.ahmad.abdou.booklender.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.entity.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookRepositoryTest  {
    List<Book> bookList;
    BookRepository bookRepository;
    Book book;
    Book book2;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @BeforeEach
    public void setup(){
        book = new Book();
        bookList = new ArrayList<>();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);

        book2 = new Book();
        book2.setTitle("OCP");
        book2.setAvailable(true);
        book2.setDescription("learn advanced Java");
        book2.setReserved(true);
        book2.setFinePerDay(new BigDecimal(10));
        book2.setMaxLoanDays(15);
//        bookRepository.save(book);
//        bookRepository.save(book2);

    }
    @Test
    public void test_findById(){
        Optional<Book> optionalBook =bookRepository.findById(1);
        bookList = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        Book book1 = new Book();
        if(optionalBook.isPresent()){
            book1 = optionalBook.get();
        }

      assertEquals(bookList.get(0),book1);
    }
    @Test
    public void test_findAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        assertEquals(bookList,books);
    }
    @Test
    public void test_delete(){
        boolean actual = false;
        bookRepository.deleteById(6);
        Optional<Book> optionalBook =bookRepository.findById(1);
        if(!optionalBook.isPresent()){
             actual = true;
        }
        System.out.println(actual);
        assertEquals(true,actual);
    }
    @Test
    public void test_findByReservedStatus(){
       List<Book> books= bookRepository.findBookByReserved(true);
       Assertions.assertEquals("learn advanced Java",books.get(0).getDescription());
    }
    @Test
    public void test_findBookByAvailability(){
        List<Book> books = bookRepository.findBookByAvailable(true);
        Assertions.assertEquals("learn Java", books.get(0).getDescription());
    }
    @Test
    public void test_findBookByTitle(){
        Book book3 = new Book();
        book3.setTitle("Python");
        book3.setAvailable(true);
        book3.setDescription("learn Python");
        book3.setReserved(false);
        book3.setFinePerDay(new BigDecimal(5));
        book3.setMaxLoanDays(10);

        bookRepository.save(book3);

        book = bookRepository.findBookByTitle("Python");
        System.out.println(book.getTitle());
        Assertions.assertEquals("Python",book3.getTitle());
    }
}
