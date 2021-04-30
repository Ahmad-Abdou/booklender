package se.lexicon.ahmad.abdou.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.ahmad.abdou.booklender.DTO.LibraryUserDto;
import se.lexicon.ahmad.abdou.booklender.DTO.LoanDto;
import se.lexicon.ahmad.abdou.booklender.entity.LibraryUser;
import se.lexicon.ahmad.abdou.booklender.entity.Loan;
import se.lexicon.ahmad.abdou.booklender.repository.BookRepository;
import se.lexicon.ahmad.abdou.booklender.repository.LibraryUserRepository;
import se.lexicon.ahmad.abdou.booklender.repository.LoanRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService{
    LoanRepository loanRepository;
    LibraryUserRepository libraryUserRepository;
    BookRepository bookRepository;
    ModelMapper modelMapper;

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

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        return   modelMapper.map(loanRepository.save(modelMapper.map(loanDto, Loan.class)),LoanDto.class);

    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        return   modelMapper.map(loanRepository.save(modelMapper.map(loanDto, Loan.class)),LoanDto.class);
    }

    @Override
    public LoanDto findById(long id) {
         if(loanRepository.findById(id).isPresent()){
             return modelMapper.map(loanRepository.findById(id).get(),LoanDto.class);
         }
        else throw new IllegalArgumentException("Id not found");
    }

    @Override
    public List<LoanDto> findByBookId(int id) {
        List<Loan> loanList = new ArrayList<>();
      loanRepository.findAll().iterator().forEachRemaining(loanList::add);

        return     loanRepository.findByBookBookId(id).stream().map(loan -> modelMapper.map(loan,LoanDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<LoanDto> findByUserId(int id) {
        List<Loan> loanList = new ArrayList<>();
        loanRepository.findAll().iterator().forEachRemaining(loanList::add);

        return loanRepository.findByLoanTakerUserId(id).stream().map(loan -> modelMapper.map(loan,LoanDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<LoanDto> findAll() {
        List<Loan> loan = new ArrayList<>();
        loanRepository.findAll().iterator().forEachRemaining(loan::add);
        return  loan.stream().map(loan1 -> modelMapper.map(loan1, LoanDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoanDto> findByTerminated(boolean terminated) {
        List<Loan> loanList = new ArrayList<>();
        loanRepository.findAll().iterator().forEachRemaining(loanList::add);
        loanRepository.findByTerminated(terminated);
        return loanList.stream().map(loan -> modelMapper.map(loan,LoanDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(long id) {
        if(loanRepository.findById(id).isPresent()){
            loanRepository.deleteById(id);
            return true;
        }
        else return false;
    }


}
