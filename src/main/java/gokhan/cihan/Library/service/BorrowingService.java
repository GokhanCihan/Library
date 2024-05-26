package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.mapper.BorrowingMapper;
import gokhan.cihan.Library.dto.request.BorrowingRequest;
import gokhan.cihan.Library.dto.response.BorrowingResponse;
import gokhan.cihan.Library.entity.Borrowing;
import gokhan.cihan.Library.repository.BorrowingRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService implements IBorrowingService {
    private final BorrowingRepository borrowingRepository;

    @Autowired
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    @Override
    public BorrowingResponse getById(Long id) {
        return BorrowingMapper.MAPPER.asOutput(this.borrowingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Borrowing data by this id (" + id + ") not found!")));
    }

    @Override
    public List<BorrowingResponse> getAll() {
        return BorrowingMapper.MAPPER.asOutput(borrowingRepository.findAll());
    }

    @Override
    public BorrowingResponse create(BorrowingRequest borrowingRequest) {
        Optional<Borrowing> searchedBorrowing = borrowingRepository.findByBorrowerAndDateBorrowedAndDateReturned(
                borrowingRequest.getBorrower(), borrowingRequest.getDateBorrowed(), borrowingRequest.getDateReturned());
        if (searchedBorrowing.isEmpty()) {
            Borrowing savedBorrowing = borrowingRepository.save(BorrowingMapper.MAPPER.asEntity(borrowingRequest));
            return BorrowingMapper.MAPPER.asOutput(savedBorrowing);
        }
        throw new NotFoundException("Borrowing data already exists!");
    }

    @Override
    public BorrowingResponse update(Long id, BorrowingRequest borrowingRequest) {
        Optional<Borrowing> borrowingFromDb = borrowingRepository.findById(id);
        if (borrowingFromDb.isEmpty()) {
            throw new NotFoundException("Borrowing data not found!");
        }
        Borrowing borrowing = borrowingFromDb.get();
        BorrowingMapper.MAPPER.update(borrowing, borrowingRequest);
        return BorrowingMapper.MAPPER.asOutput(borrowingRepository.save(borrowing));
    }

    @Override
    public void delete(Long id) {
        Optional<Borrowing> borrowing = borrowingRepository.findById(id);
        if (borrowing.isPresent()) {
            borrowingRepository.delete(borrowing.get());
        } else {
            throw new NotFoundException("Borrowing data not found");
        }
    }
}
