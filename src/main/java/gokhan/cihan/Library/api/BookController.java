package gokhan.cihan.Library.api;

import gokhan.cihan.Library.business.IBookService;
import gokhan.cihan.Library.dto.request.BookRequest;
import gokhan.cihan.Library.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {
    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable("id") Long id){
        return bookService.getById(id);
    }

    @GetMapping()
    public List<BookResponse> getAll() {
        return bookService.getAll();
    }

    @PostMapping()
    public BookResponse create(BookRequest bookRequest) {
        return bookService.create(bookRequest);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable("id") Long id, BookRequest bookRequest) {
        return bookService.update(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        bookService.delete(id);
    }
}
