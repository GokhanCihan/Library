package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Author;

import java.util.List;

public interface IAuthorService {

    Author getById(long id);

    List<Author> getAll(int page, int pageSize);

    Author save(Author author);

    Author update(Author author);

    boolean delete(long id);

}
