package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.mapper.BookMapper;
import gokhan.cihan.Library.dto.request.BookRequest;
import gokhan.cihan.Library.dto.response.BookResponse;
import gokhan.cihan.Library.entity.Book;
import gokhan.cihan.Library.repository.BookRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse getById(Long id) {
        return BookMapper.MAPPER.asOutput(this.bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book data by this id (" + id + ") not found!")));
    }

    @Override
    public List<BookResponse> getAll() {
        return BookMapper.MAPPER.asOutput(bookRepository.findAll());
    }

    @Override
    public BookResponse create(BookRequest bookRequest) {
        Optional<Book> searchedBook = bookRepository.findByTitleAndYearPublished(bookRequest.getTitle(), bookRequest.getYearPublished());
        if (searchedBook.isEmpty()) {
            Book savedBook = bookRepository.save(BookMapper.MAPPER.asEntity(bookRequest));
            return BookMapper.MAPPER.asOutput(savedBook);
        }
        throw new NotFoundException("Book already exists!");
    }

    @Override
    public BookResponse update(Long id, BookRequest bookRequest) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isEmpty()) {
            throw new NotFoundException("Book not found!");
        }
        Book book = bookFromDb.get();
        BookMapper.MAPPER.update(book, bookRequest);
        return BookMapper.MAPPER.asOutput(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        } else {
            throw new NotFoundException("Book data not found");
        }
    }
}
