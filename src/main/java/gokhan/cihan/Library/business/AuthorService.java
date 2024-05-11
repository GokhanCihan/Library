package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Author;
import gokhan.cihan.Library.repository.AuthorRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(long id) {
        return this.authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author data not found!"));
    }

    @Override
    public Page<Author> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.authorRepository.findAll(pageable);
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        this.getById(author.getId());
        return this.authorRepository.save(author);
    }

    @Override
    public boolean delete(long id) {
        this.authorRepository.delete(this.getById(id));
        return false;
    }
}
