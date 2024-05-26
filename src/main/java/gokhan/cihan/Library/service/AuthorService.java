package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.mapper.AuthorMapper;
import gokhan.cihan.Library.dto.request.AuthorRequest;
import gokhan.cihan.Library.dto.response.AuthorResponse;
import gokhan.cihan.Library.entity.Author;
import gokhan.cihan.Library.repository.AuthorRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorResponse getById(Long id) {
        return AuthorMapper.MAPPER.asOutput(this.authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author data not found!")));
    }

    @Override
    public List<AuthorResponse> getAll() {
        return AuthorMapper.MAPPER.asOutput(this.authorRepository.findAll());
    }

    @Override
    public AuthorResponse create(AuthorRequest authorRequest) {
        Optional<Author> searchedAuthor = authorRepository.findByNameAndYearOfBirthAndCountry(authorRequest.getName(),
                authorRequest.getYearOfBirth(), authorRequest.getCountry());
        if (searchedAuthor.isEmpty()) {
            Author savedAuthor = authorRepository.save(AuthorMapper.MAPPER.asEntity(authorRequest));
            return AuthorMapper.MAPPER.asOutput(savedAuthor);
        }
        throw new NotFoundException("This author already exists!");
    }

    @Override
    public AuthorResponse update(Long id, AuthorRequest authorRequest) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isEmpty()) {
            throw new NotFoundException("Author not found!");
        }
        Author author = authorFromDb.get();
        AuthorMapper.MAPPER.update(author, authorRequest);
        return AuthorMapper.MAPPER.asOutput(authorRepository.save(author));
    }

    @Override
    public void delete(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            authorRepository.delete(author.get());
        } else {
            throw new NotFoundException("Author not found");
        }
    }
}
