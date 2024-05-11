package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Borrowing;

import java.util.List;

public interface IBorrowingService {

    Borrowing getById(long id);

    List<Borrowing> getAll(int page, int pageSize);

    Borrowing save(Borrowing borrowing);

    Borrowing update(Borrowing borrowing);

    boolean delete(long id);

}
