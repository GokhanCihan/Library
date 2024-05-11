package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Borrowing;
import gokhan.cihan.Library.repository.BorrowingRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowingService implements IBorrowingService {
    private final BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    @Override
    public Borrowing getById(long id) {
        return this.borrowingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Borrowing data not found!"));
    }

    @Override
    public Page<Borrowing> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.borrowingRepository.findAll(pageable);
    }

    @Override
    public Borrowing save(Borrowing borrowing) {
        return this.borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing update(Borrowing borrowing) {
        this.getById(borrowing.getId());
        return this.borrowingRepository.save(borrowing);
    }

    @Override
    public boolean delete(long id) {
        this.borrowingRepository.delete(this.getById(id));
        return false;
    }
}
