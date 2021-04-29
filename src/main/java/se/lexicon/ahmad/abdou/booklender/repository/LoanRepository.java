package se.lexicon.ahmad.abdou.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.ahmad.abdou.booklender.entity.Loan;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan,Long> {

            Loan findByLoanTakerUserId(int id);

            Loan findByBookBookId(int id);

            List<Loan> findByTerminated(boolean terminated);
}
