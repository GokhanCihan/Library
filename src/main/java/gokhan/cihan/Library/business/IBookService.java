package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Book;

import java.util.List;

public interface IBookService {

    Book getById(long id);

    List<Book> getAll(int page, int pageSize);

    Book save(Book book);

    Book update(Book book);

    boolean delete(long id);

}
