package se.lexicon.ahmad.abdou.booklender.service;

import se.lexicon.ahmad.abdou.booklender.DTO.LoanDto;
import se.lexicon.ahmad.abdou.booklender.Exception.ArgumentException;
import se.lexicon.ahmad.abdou.booklender.Exception.RecordNotFoundException;

import java.util.List;

public interface LoanService {

    LoanDto create(LoanDto loanDto)throws ArgumentException ;

    LoanDto update(LoanDto loanDto) ;

    LoanDto findById(long id);

    List<LoanDto> findByBookId(long id) throws ArgumentException;

    List<LoanDto> findByUserId(long id) throws RecordNotFoundException;

    List<LoanDto> findAll();

    List<LoanDto> findByTerminated(boolean terminated) ;

    boolean deleteById(long id);

}
