package gokhan.cihan.Library.repository;

import gokhan.cihan.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
