package se.lexicon.ahmad.abdou.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
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
    public LoanServiceImpl(LoanRepository loanRepository, LibraryUserRepository libraryUserRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.libraryUserRepository = libraryUserRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        Loan loanEntity = modelMapper.map(loanDto,Loan.class);
        Loan saved =  loanRepository.save(loanEntity);
        LoanDto  loanDto1 = modelMapper.map(saved,LoanDto.class);

        LibraryUser libraryUser = libraryUserRepository.findByUserId(saved.getLoanTaker().getUserId()).get();
        loanDto1.setLoanTakerDto(modelMapper.map(libraryUser,LibraryUserDto.class));
        System.out.println(libraryUser);

        BookDto bookDto = modelMapper.map(bookRepository.findByBookId(saved.getBook().getBookId()).get(),BookDto.class);
        loanDto1.setBookDto(bookDto);

        return   loanDto1;

    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        return   modelMapper.map(loanRepository.save(modelMapper.map(loanDto, Loan.class)),LoanDto.class);
    }

    @Override
    public LoanDto findById(long id) {
        LoanDto loanDto = modelMapper.map(loanRepository.findByLoanId(id),LoanDto.class);
        loanDto.setLoanTakerDto(modelMapper.map(libraryUserRepository.findByUserId(id).get(),LibraryUserDto.class));
        loanDto.setBookDto(modelMapper.map(bookRepository.findByBookId(id),BookDto.class));
     return  loanDto;
    }

    @Override
    public List<LoanDto> findByBookId(long id) {
        List<Loan> loanList = new ArrayList<>();
      loanRepository.findAll().iterator().forEachRemaining(loanList::add);

        return   loanRepository.findByBookBookId(id).stream().map(loan -> modelMapper.map(loan,LoanDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<LoanDto> findByUserId(long id) {
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
