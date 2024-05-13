package gokhan.cihan.Library.business;

import gokhan.cihan.Library.dto.request.BookRequest;
import gokhan.cihan.Library.dto.response.BookResponse;

import java.util.List;

public interface IBookService {

    BookResponse getById(Long id);

    List<BookResponse> getAll();

    BookResponse create(BookRequest bookRequest);

    BookResponse update(Long id, BookRequest bookRequest);

    void delete(Long id);

}
