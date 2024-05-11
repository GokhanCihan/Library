package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Book;
import org.springframework.data.domain.Page;

public interface IBookService {

    Book getById(long id);

    Page<Book> getAll(int page, int pageSize);

    Book save(Book book);

    Book update(Book book);

    boolean delete(long id);

}
