package gokhan.cihan.Library.repository;

import gokhan.cihan.Library.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findByBorrowerAndDateBorrowedAndDateReturned(String borrower, LocalDate dateBorrowed, LocalDate dateReturned);
}
