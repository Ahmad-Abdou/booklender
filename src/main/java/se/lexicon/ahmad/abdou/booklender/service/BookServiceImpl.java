package se.lexicon.ahmad.abdou.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.ahmad.abdou.booklender.DTO.BookDto;
import se.lexicon.ahmad.abdou.booklender.entity.Book;
import se.lexicon.ahmad.abdou.booklender.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> findByReserved(boolean reserved) {

        return  bookRepository.findBookByReserved(reserved).stream().map(book1 -> modelMapper.map(book1,BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAvailability(boolean available) {

        return bookRepository.findBookByAvailable(available).stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .stream()
                .map(book -> modelMapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(int id) {
        if(id <= 0) throw new IllegalArgumentException("id not found");
        Optional<Book> book =bookRepository.findById(id);
        if(book.isPresent()){
            return modelMapper.map(book.get(),BookDto.class);
        }
       else throw new IllegalArgumentException("id not found");
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = new ArrayList<>();
      bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        return bookList.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookDto create(BookDto bookDto) {
        return modelMapper.map( bookRepository.save(modelMapper.map(bookDto,Book.class)),BookDto.class);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        return modelMapper.map( bookRepository.save(modelMapper.map(bookDto,Book.class)),BookDto.class);
    }

    @Override
    public boolean deleteById(int id) {
        if(id<= 0) throw new IllegalArgumentException("ID not found");
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }
       else return false;
    }

}
