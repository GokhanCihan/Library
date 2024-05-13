package gokhan.cihan.Library.repository;

import gokhan.cihan.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndYearOfBirthAndCountry(String name, Integer yearOfBirth, String country);
}
