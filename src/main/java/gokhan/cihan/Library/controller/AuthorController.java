package gokhan.cihan.Library.controller;

import gokhan.cihan.Library.service.IAuthorService;
import gokhan.cihan.Library.dto.request.AuthorRequest;
import gokhan.cihan.Library.dto.response.AuthorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorResponse getById(@PathVariable("id") Long id){
        return authorService.getById(id);
    }

    @GetMapping()
    public List<AuthorResponse> getAll() {
        return authorService.getAll();
    }

    @PostMapping()
    public AuthorResponse create(AuthorRequest authorRequest) {
        return authorService.create(authorRequest);
    }

    @PutMapping("/{id}")
    public AuthorResponse update(@PathVariable("id") Long id, AuthorRequest authorRequest) {
        return authorService.update(id, authorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        authorService.delete(id);
    }
}
