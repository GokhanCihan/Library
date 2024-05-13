package gokhan.cihan.Library.repository;

import gokhan.cihan.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleAndYearPublished(String title, Integer yearPublished);
}
