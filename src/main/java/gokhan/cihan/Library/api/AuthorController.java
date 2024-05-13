package gokhan.cihan.Library.api;

import gokhan.cihan.Library.business.IAuthorService;
import gokhan.cihan.Library.dto.request.AuthorRequest;
import gokhan.cihan.Library.dto.response.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
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
