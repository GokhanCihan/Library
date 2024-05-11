package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {

    Author getById(long id);

    Page<Author> getAll(int page, int pageSize);

    Author save(Author author);

    Author update(Author author);

    boolean delete(long id);

}