package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Book;
import gokhan.cihan.Library.repository.BookRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book data not found!"));
    }

    @Override
    public Page<Book> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        this.getById(book.getId());
        return this.bookRepository.save(book);
    }

    @Override
    public boolean delete(long id) {
        this.bookRepository.delete(this.getById(id));
        return false;
    }
}
