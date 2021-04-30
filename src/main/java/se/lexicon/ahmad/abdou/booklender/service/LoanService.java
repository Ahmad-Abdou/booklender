package se.lexicon.ahmad.abdou.booklender.service;

import se.lexicon.ahmad.abdou.booklender.DTO.LoanDto;

import java.util.List;

public interface LoanService {

    LoanDto create(LoanDto loanDto);

    LoanDto update(LoanDto loanDto);

    LoanDto findById(long id);

    List<LoanDto> findByBookId(int id);

    List<LoanDto> findByUserId(int id);

    List<LoanDto> findAll();

    List<LoanDto> findByTerminated(boolean terminated);

    boolean deleteById(long id);

}
