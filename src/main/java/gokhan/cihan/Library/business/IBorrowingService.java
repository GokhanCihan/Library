package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Borrowing;
import org.springframework.data.domain.Page;

public interface IBorrowingService {

    Borrowing getById(long id);

    Page<Borrowing> getAll(int page, int pageSize);

    Borrowing save(Borrowing borrowing);

    Borrowing update(Borrowing borrowing);

    boolean delete(long id);

}
