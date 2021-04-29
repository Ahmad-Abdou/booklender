package se.lexicon.ahmad.abdou.booklender.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ahmad.abdou.booklender.entity.Book;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;
import se.lexicon.ahmad.abdou.booklender.entity.Loan;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class LoanRepositoryTest {

    LoanRepository loanRepository;
    LibraryUserRepository libraryUserRepository;
    BookRepository bookRepository;
    Loan loan;
    Book book;
    LibraryUser libraryUser;

    @Autowired
    public void setLoanRepository(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Autowired
    public void setLibraryUserRepository(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @BeforeEach
    public void setup(){
        book = new Book();
        book.setTitle("OCA");
        book.setAvailable(true);
        book.setDescription("learn Java");
        book.setReserved(false);
        book.setFinePerDay(new BigDecimal(5));
        book.setMaxLoanDays(10);
//        bookRepository.save(book);

        libraryUser = new LibraryUser();
        libraryUser.setRegDate(LocalDate.now());
        libraryUser.setName("Ahmad");
        libraryUser.setEmail("test@3.com");
//        libraryUserRepository.save(libraryUser);

        loan = new Loan();
        loan.setLoanTaker(libraryUser);
        loan.setBook(book);
        loan.setLocalDate(LocalDate.now());
        loan.setTerminated(false);
//        loanRepository.save(loan);


    }
    @Test
    public void findAll(){
        List<Loan> loanList = new ArrayList<>();
        loanRepository.findAll().iterator().forEachRemaining(loanList::add);
        System.out.println(loanList);
        Assertions.assertEquals(3,loanList.size());
    }
    @Test
    public void test_findByLoanTakerUserId(){
       String email = loanRepository.findByLoanTakerUserId(12).getLoanTaker().getEmail();
        Assertions.assertEquals("test@test.com",email);
    }
    @Test
    public void test_findByBookBookId(){
       String title = loanRepository.findByBookBookId(32).getBook().getTitle();
        Assertions.assertEquals("OCA",title);
    }
   @Test
    public void test_findByTerminated(){
        List<Loan> loanList = new ArrayList<>();
       loanRepository.findByTerminated(false).iterator().forEachRemaining(loanList::add);
       Assertions.assertEquals(loan.isTerminated(),false);
   }

}
